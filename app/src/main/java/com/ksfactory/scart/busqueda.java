package com.ksfactory.scart;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.miguelcatalan.materialsearchview.MaterialSearchView;


public class busqueda extends Fragment {
    SearchView searchView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_busqueda, container, false);

        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return vista;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        searchView =  getView().findViewById(R.id.action_search);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setQueryHint("Busca productos");
       // searchView.setOnQueryTextListener();
        searchView.setIconified(false);
    }

}
