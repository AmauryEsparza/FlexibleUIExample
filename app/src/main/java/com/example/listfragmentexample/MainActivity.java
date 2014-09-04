package com.example.listfragmentexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements MyListFragment.CommunicatorInterface{

    FragmentDescription fragmentDescription;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
    }

    @Override
    public void respond(int index){
        Log.d("MainActivity", "respond");
        fragmentDescription = (FragmentDescription) fragmentManager.findFragmentById(R.id.fragment2);
        fragmentDescription.changeData(index);



    }



}
