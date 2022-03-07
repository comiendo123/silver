package com.example.appsilvermin.administrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.appsilvermin.R;
import com.example.appsilvermin.administrador.adminverceldas.adminverceldas;
import com.example.appsilvermin.administrador.adminverreportes.adminverreportes;
import com.example.appsilvermin.administrador.adminverusuarios.adminverusuarios;

public class administrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);



        ImageView verusuarios= this.findViewById(R.id.botonverusuarios);
        ImageView verceldas= this.findViewById(R.id.botonverceldas);
        ImageView verreportes = this.findViewById(R.id.botonverreportes);

        verusuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), adminverusuarios.class);
                startActivityForResult(intent, 0);
            }
        });
        verceldas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), adminverceldas.class);
                startActivityForResult(intent, 0);
            }
        });
        verreportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), adminverreportes.class);
                startActivityForResult(intent, 0);
            }
        });
    }
    }
