package com.ksfactory.scart;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;


public class perfil_opcional extends Fragment{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista =inflater.inflate(R.layout.fragment_perfil_opcional, container, false);
        // Inflate the layout for this fragment
   /*     View include = vista.findViewById(R.id.include);

        HorizontalScrollView horizontal = include.findViewById(R.id.horizontal);
        horizontal.setHorizontalScrollBarEnabled(false);*/

        ScrollView vertical = vista.findViewById(R.id.vertical);
        vertical.setVerticalScrollBarEnabled(false);


        return vista;
    }

}
