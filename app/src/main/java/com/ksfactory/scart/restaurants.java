package com.ksfactory.scart;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


public class restaurants extends Fragment {
    public GridView gridView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_restaurants, container, false);
        // Inflate the layout for this fragment
        gridView = vista.findViewById(R.id.grid);
        casijson();
        return vista;
    }



    public void casijson(){
        ArrayList<String> nombre = new ArrayList<>() ,desc = new ArrayList<>(),
                ciudad = new ArrayList<>(),images = new ArrayList<>();
        ArrayList<Float> rating= new ArrayList<>();

        //7 de cu

        images.add("https://res.cloudinary.com/simpleview/image/upload/c_fill,f_auto,h_600,q_75," +
                "w_900/v1/clients/napavalley/Meadowood_Napa_valley_686b7d6e-14fa-4e4e-9873-" +
                "66d6d11fb466.jpg");
        images.add("https://www.wien.info/media/images/41993-das-loft-sofitel-19to1.jpeg");
        images.add("http://sirenuse.it/media/39633/bar_restaurants_lasponda_1michelin-star-" +
                "positano_02.jpg");
        images.add("https://cdn.theculturetrip.com/wp-content/uploads/2017/05/" +
                "azure-restaurant-at-the-12-apostles-hotel-and-spa-1024x680.jpg");
        images.add("https://media.gq.com/photos/573e23554bf860ff12c0e961/master" +
                "/w_2000/best-restaurants-gq-0616-03.jpg");
        images.add("http://image.cleveland.com/home/cleve-media/width620/img/dining-guide/photo/" +
                "cleveland-classic-restaurants-aldos-8e76cfa14bae1238.jpg");
        images.add("https://www.tropical-islands.de/fileadmin/_processed_/" +
                "csm_TI_RESTAURANT_TROPICAL-GARDEN1_RGB_2000x860_c3a4238088.jpg");
        for (int i = 0; i < images.size(); i++) {
            nombre.add("Restaurant N°"+(1+i));
        }
        for (int i = 0; i < images.size(); i++) {
            desc.add("Especialidad");
        }
        for (int i = 0; i < images.size(); i++) {
            ciudad.add("ciudad");
        }
        for (int i = 0; i < images.size(); i++) {
            float valor = (float) (Math.random() * 5) + 1;
            rating.add(valor);
        }

        gridView.setAdapter(new ImageAdapter(getContext(),nombre,images,desc,ciudad,rating));
    }
}
