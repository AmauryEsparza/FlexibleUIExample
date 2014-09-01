package com.example.listfragmentexample;
import android.app.ListFragment;
import android.os.Bundle;
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

public class MyListFragment extends ListFragment implements AdapterView.OnItemClickListener{

    CommunicatorInterface communicator;

    public void setCommunicator(CommunicatorInterface communicator){
        this.communicator = communicator;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.star_wars_characters,android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
        communicator.respond(i);
        Toast.makeText(getActivity(), "Item "+i, Toast.LENGTH_LONG).show();

    }

    public interface CommunicatorInterface{
        public void respond(int index);
    }

}
