package com.example.appsilvermin.administrador.adminverceldas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.appsilvermin.R;
import com.example.appsilvermin.administrador.adminverceldas.chancadora.chancadora;
import com.example.appsilvermin.administrador.adminverceldas.flotacion.celda;
import com.example.appsilvermin.administrador.adminverceldas.molino.molino;

import java.util.ArrayList;

public class adminverceldas extends AppCompatActivity {
 //   SwipeRefreshLayout swipeRefreshLayout;
    String url = "http://10.0.2.2:8000/api/informes/";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
   // private listaadaptercelda adapter;
   // private List<listaelementcelda> celda = new ArrayList<>();
   // private apiservice apiInterface;
    ImageView ingresar;

    Button ingresarchancador,ingresarmolienda,ingresarflotacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminverceldas);

        ingresarchancador=findViewById(R.id.agregarchancadora);
        ingresarmolienda=findViewById(R.id.agregarmolino);
        ingresarflotacion=findViewById(R.id.agregarcelda);
        //  swipeRefreshLayout = this.findViewById(R.id.swipeequipos);
        // ingresar = this.findViewById(R.id.ingresarreorte);

        ingresarchancador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), chancadora.class);
                startActivityForResult(intent, 0);
            }
        });
        ingresarmolienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), molino.class);
                startActivityForResult(intent, 0);
            }
        });
        ingresarflotacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), celda.class);
                startActivityForResult(intent, 0);
            }
        });

       /*ingresar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(v.getContext(), administradoragragarreorte.class);
               startActivityForResult(intent, 0);
           }
       });*/





/*ESTO ES PARA VR CELDAS
        apiInterface = retrofet.getApiInforme().create(apiservice.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<List<listaelementcelda>> call = apiInterface.getCelda();
        call.enqueue(new Callback<List<listaelementcelda>>() {
            @Override
            public void onResponse(Call<List<listaelementcelda>> call, Response<List<listaelementcelda>> response) {
                celda = response.body();
                RecyclerView recyclerView = findViewById(R.id.reciclerviewcelda);
                listaadaptercelda adapter = new listaadaptercelda(adminverceldas.this, celda);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(adminverceldas.this));
            }

            @Override
            public void onFailure(Call<List<listaelementcelda>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Toast por defecto", Toast.LENGTH_SHORT);

            }
        });


        ///ARA REFRESCAR

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                apiInterface = retrofet.getApiInforme().create(apiservice.class);
                Log.d(TAG, "initRecyclerView: init recyclerciew.");

                Call<List<listaelementcelda>> call = apiInterface.getCelda();
                call.enqueue(new Callback<List<listaelementcelda>>() {
                    @Override
                    public void onResponse(Call<List<listaelementcelda>> call, Response<List<listaelementcelda>> response) {
                        celda = response.body();
                        RecyclerView recyclerView = findViewById(R.id.reciclerviewcelda);
                        listaadaptercelda adapter = new listaadaptercelda(adminverceldas.this, celda);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(adminverceldas.this));
                    }

                    @Override
                    public void onFailure(Call<List<listaelementcelda>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Toast por defecto", Toast.LENGTH_SHORT);

                    }
                });


                //cierre de refresh
                swipeRefreshLayout.setRefreshing(false);

            }


        });
//hastaaqui

    }*/
    }
}
