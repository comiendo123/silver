package com.example.appsilvermin.almacenero.equipo;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appsilvermin.R;
import com.example.appsilvermin.almacenero.equipo.insertarequipo.adaptadorequipos;
import com.example.appsilvermin.almacenero.equipo.insertarequipo.insertarequipo;
import com.example.appsilvermin.almacenero.equipo.insertarequipo.itemequipo;
import com.example.appsilvermin.almacenero.reactivo.insertarreactivos.insertarreactivos;

import com.example.appsilvermin.apiservice.ApiInterface;
import com.example.appsilvermin.apiservice.retrofet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class verequipos extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private adaptadorequipos adapter;
    private List<itemequipo> equipo = new ArrayList<>();
    private ApiInterface apiInterface;
    ImageView ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verequipos);


        recyclerView = findViewById(R.id.recyclerhistorialalmacen);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        swipeRefreshLayout = this.findViewById(R.id.swipeequipo);
        ingresar = this.findViewById(R.id.imagenagregarequipo);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), insertarequipo.class);
                startActivityForResult(intent, 0);
            }
        });


        apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<List<itemequipo>> call = apiInterface.getEquipo();
        call.enqueue(new Callback<List<itemequipo>>() {
            @Override
            public void onResponse(Call<List<itemequipo>> call, retrofit2.Response<List<itemequipo>> response) {
                equipo = response.body();
                RecyclerView recyclerView = findViewById(R.id.recyclerhistorialalmacen);
                adaptadorequipos adapter = new adaptadorequipos(verequipos.this, equipo);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(verequipos.this));
            }

            @Override
            public void onFailure(Call<List<itemequipo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Toast por defecto", Toast.LENGTH_SHORT);

            }
        });


        ///ARA REFRESCAR

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                apiInterface = retrofet.getApiInforme().create(ApiInterface.class);
                Log.d(TAG, "initRecyclerView: init recyclerciew.");

                Call<List<itemequipo>> call = apiInterface.getEquipo();
                call.enqueue(new Callback<List<itemequipo>>() {
                    @Override
                    public void onResponse(Call<List<itemequipo>> call, Response<List<itemequipo>> response) {
                        equipo = response.body();
                        RecyclerView recyclerView = findViewById(R.id.recyclerhistorialalmacen);
                        adaptadorequipos adapter = new adaptadorequipos(verequipos.this, equipo);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(verequipos.this));
                    }

                    @Override
                    public void onFailure(Call<List<itemequipo>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Toast por defecto", Toast.LENGTH_SHORT);

                    }
                });


                //cierre de refresh
                swipeRefreshLayout.setRefreshing(false);

            }


        });
//hastaaqui

    }
    }