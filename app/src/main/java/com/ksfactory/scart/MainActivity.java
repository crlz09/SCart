package com.ksfactory.scart;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    SpaceNavigationView spaceNavigationView;
    String[] tituloTabs={"Mi Perfil", "Busqueda", "Restaurants", "Contenido destacado"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         spaceNavigationView= findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("Perfil", R.drawable.ic_person_white_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("Buscar", R.drawable.ic_search_white_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("Restaurants", R.drawable.ic_local_dining_white_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("Promociones", R.drawable.ic_error_white_24dp));
        spaceNavigationView.setSpaceBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        spaceNavigationView.setCentreButtonIcon(R.drawable.barcode3);
        spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this, R.color.Circule));
        spaceNavigationView.showIconOnly();
        setTitle("Smiling Cart");
        FragmentManager fragmentManager= getSupportFragmentManager();
        //ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        fragmentManager.beginTransaction().replace(R.id.contenedor,new perfil_opcional()).commit();


        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
               // Toast.makeText(MainActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),alternate_scan.class));
               // FragmentManager fragmentManager= getSupportFragmentManager();
               // fragmentManager.beginTransaction().replace(R.id.contenedor,new escanear()).commit();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
               // Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager= getSupportFragmentManager();
                switch (itemIndex) {
                    case 0:
                        fragmentManager.beginTransaction().replace(R.id.contenedor,new perfil_opcional()).commit();
                        setTitle(tituloTabs[itemIndex]);
                        break;
                    case 1:
                        fragmentManager.beginTransaction().replace(R.id.contenedor,new busqueda()).commit();
                        setTitle(tituloTabs[itemIndex]);
                        break;
                    case 2:
                        fragmentManager.beginTransaction().replace(R.id.contenedor,new restaurants()).commit();
                        setTitle(tituloTabs[itemIndex]);
                        break;
                    case 3:
                        fragmentManager.beginTransaction().replace(R.id.contenedor,new patrocinado()).commit();
                        setTitle(tituloTabs[itemIndex]);
                        break;
                }

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
               // Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
                setTitle(tituloTabs[itemIndex]);
            }
        });

    }

   /* public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position){
                case 0: return new perfil();
                case 1: return new busqueda();
                case 2: return new restaurants();
                case 3: return new patrocinado();
                // case 3: return new destacados();
            }

            return null;
        }



        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tituloTabs[position];
        }
    }*/

}
