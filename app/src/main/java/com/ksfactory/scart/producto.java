package com.ksfactory.scart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class producto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        String codigo = getIntent().getExtras().getString("codigo");

        TextView texto= findViewById(R.id.texto);
        texto.setText(codigo);
    }
}
