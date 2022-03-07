package com.example.appsilvermin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.appsilvermin.administrador.administrador;
import com.example.appsilvermin.almacenero.almacenero;
import com.example.appsilvermin.molinero.usuariomolinero;
import com.example.appsilvermin.reactiveros.usuarioreactivero;
import com.example.appsilvermin.superusuario.superactivity;
import com.example.appsilvermin.tritudorista.usuariotritudorista;

public class MainActivity extends AppCompatActivity {

        EditText editnombre, editpassword;
        Button chancado,molienda,flotacion,superusuario;
        String cargo, ciusuario, passwordd;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            String URL = "http://10.0.0.2:8000/api/usuario";
            ImageView invitado = this.findViewById(R.id.botoninvitado);

            ImageView ingresar = this.findViewById(R.id.botonmodificarcelda);
            ImageView olvidado = this.findViewById(R.id.botonpassword);
superusuario=findViewById(R.id.superusuario);

            editnombre = findViewById(R.id.editnombre);
            editpassword = findViewById(R.id.editpassword);
            chancado=findViewById(R.id.chancado);
            molienda=findViewById(R.id.molienda);
            flotacion=findViewById(R.id.flotacion);


            chancado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), usuariotritudorista.class);
                    startActivityForResult(intent, 0);
                }
            });

            superusuario.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), superactivity.class);
                    startActivityForResult(intent, 0);
                }
            });
            molienda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), usuariomolinero.class);
                    startActivityForResult(intent, 0);
                }
            });
            flotacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), usuarioreactivero.class);
                    startActivityForResult(intent, 0);
                }
            });




            invitado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), invitado.class);
                    startActivityForResult(intent, 0);
                }
            });
            ingresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), administrador.class);
                    startActivityForResult(intent, 0);
                }
            });
            olvidado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), almacenero.class);// olvidopasword.class);
                    startActivityForResult(intent, 0);
                }
            });
        }



    }

