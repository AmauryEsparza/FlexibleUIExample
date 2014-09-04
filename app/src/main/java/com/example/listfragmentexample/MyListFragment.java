package com.example.listfragmentexample;
import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Amaury Esparza on 30/08/2014.
 */

public class MyListFragment extends ListFragment{

    CommunicatorInterface communicator;

    public interface CommunicatorInterface{
        public void respond(int index);
    }

    @Override
    public void onAttach(Activity activity){
        Log.d("MyListFragment", "onAttach");
        super.onAttach(activity);
        try{
            communicator = (CommunicatorInterface) activity;
        }catch(ClassCastException ex){
            throw new ClassCastException(activity.toString() + " must implement CommunicatorInterface");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.d("MyListFragment", "onCreateView");
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        Log.d("MyListFragment", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.star_wars_characters,android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Log.d("MyListFragment", "onListItemClick");
        communicator.respond(position);
        Toast.makeText(getActivity(), "Item " + position , Toast.LENGTH_LONG).show();
    }





}
