package com.example.appsilvermin.almacenero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appsilvermin.R;
import com.example.appsilvermin.almacenero.equipo.verequipos;
import com.example.appsilvermin.almacenero.historial.verhistorial;
import com.example.appsilvermin.almacenero.reactivo.insertarreactivos.verreactivos;

public class almacenero extends AppCompatActivity {

    Button equipo, reactivo, historial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacenero);

        equipo=findViewById(R.id.verequipoalmacenero);
        reactivo=findViewById(R.id.verreactivo);
        historial=findViewById(R.id.historialequipo);

        equipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), verequipos.class);
                startActivityForResult(intent, 0);
            }
        });
        reactivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), verreactivos.class);
                startActivityForResult(intent, 0);
            }
        });
        historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), verhistorial.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}