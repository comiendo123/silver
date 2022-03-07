package com.example.appsilvermin.superusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appsilvermin.R;
import com.example.appsilvermin.almacenero.equipo.verequipos;
import com.example.appsilvermin.superusuario.verdatos.verdatos;
import com.example.appsilvermin.superusuario.vertrabajadores.vertrabajadores;
import com.example.appsilvermin.tritudorista.usuariotritudorista;

public class superactivity extends AppCompatActivity {

    Button ingresardatos,verdatos,vertrabajadores,verequipos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superactivity);

        ingresardatos=findViewById(R.id.ingresarprocesos);
        verdatos=findViewById(R.id.verprocesos);
        vertrabajadores=findViewById(R.id.vertrabajadores);

        verequipos=findViewById(R.id.verequipos);


        ingresardatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//VER PROCESOS
                Intent intent = new Intent(v.getContext(), com.example.appsilvermin.superusuario.ingresardatos.ingresardatos.class);
                startActivityForResult(intent, 0);
            }
        });


        verdatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//VER PROCESOS
                Intent intent = new Intent(v.getContext(), com.example.appsilvermin.superusuario.verdatos.verdatos.class);
                startActivityForResult(intent, 0);
            }
        });

        verequipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), com.example.appsilvermin.superusuario.verequipos.verequipos.class);
                startActivityForResult(intent, 0);
            }
        });
        vertrabajadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), com.example.appsilvermin.superusuario.vertrabajadores.vertrabajadores.class);
                startActivityForResult(intent, 0);
            }
        });
     /*   verequipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), usuariotritudorista.class);
                startActivityForResult(intent, 0);
            }
        });*/
    }
}