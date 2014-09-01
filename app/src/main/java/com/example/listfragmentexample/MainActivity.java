package com.example.listfragmentexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements MyListFragment.CommunicatorInterface{

    MyListFragment listFragment;
    FragmentDescription fragmentDescription;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        listFragment = new MyListFragment();
        listFragment.setCommunicator(this);
    }

    @Override
    public void respond(int index){
        fragmentDescription = (FragmentDescription) fragmentManager.findFragmentById(R.id.description_fragment);
        fragmentDescription.changeData(index);



    }



}
