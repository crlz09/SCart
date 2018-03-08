package com.ksfactory.scart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private ArrayList<String> images;
    private ArrayList<String> nombres,descripciones,ciudades,cats;
    private ArrayList<String> distances;
    LayoutInflater inflater;
    private ArrayList<Float> ratings;
    private Context context;

    public ImageAdapter(Context context, ArrayList<String> nombre, ArrayList<String> drawables, ArrayList<String> descripcion,
                        ArrayList<String> ciudad, ArrayList<Float> rating) {

        this.images = drawables;
        this.nombres=nombre;
        this.descripciones=descripcion;
        this.ciudades=ciudad;
        this.ratings=rating;
        this.context=context;
      //          inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {

        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        final LinearLayout layfondo =  view.findViewById(R.id.layFondo);
        TextView nombre =  view.findViewById(R.id.nombreLay);
        TextView descripcion =  view.findViewById(R.id.descripcioLay);
        RatingBar ratingBar= view.findViewById(R.id.ratingBar);
        TextView ciudad = view.findViewById(R.id.ciudad);
        Glide.with(context).load(images.get(position)).asBitmap().centerCrop().into(new SimpleTarget<Bitmap>() {

            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    layfondo.setBackground(drawable);
                }
            }
        });

        String nombreaux;

        if (nombres.get(position).length()>20){
             nombreaux= nombres.get(position).substring(0,20)+"..";
        } else nombreaux=nombres.get(position);


        ratingBar.setStepSize(0.5f);
        nombre.setText(nombreaux);
        descripcion.setText(descripciones.get(position));
        ciudad.setText(ciudades.get(position));
        ratingBar.setRating(ratings.get(position));

        return view;
    }



}