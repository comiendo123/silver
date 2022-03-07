package com.example.appsilvermin.almacenero.reactivo.insertarreactivos;

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
import com.example.appsilvermin.administrador.adminverceldas.chancadora.agregarchancadora;
import com.example.appsilvermin.apiservice.ApiInterface;
import com.example.appsilvermin.apiservice.retrofet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class verreactivos extends AppCompatActivity {


    SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private adaptadorreactivo adapter;
    private List<itemreactivo> reactivo = new ArrayList<>();
    private ApiInterface apiInterface;
    ImageView ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verreactivos);


        recyclerView = findViewById(R.id.recyclerreactivo);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        swipeRefreshLayout = this.findViewById(R.id.swipe);
        ingresar = this.findViewById(R.id.imagenagregarreactivo);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), insertarreactivos.class);
                startActivityForResult(intent, 0);
            }
        });


        apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<List<itemreactivo>> call = apiInterface.getReactivo();
        call.enqueue(new Callback<List<itemreactivo>>() {
            @Override
            public void onResponse(Call<List<itemreactivo>> call, retrofit2.Response<List<itemreactivo>> response) {
                reactivo = response.body();
                RecyclerView recyclerView = findViewById(R.id.recyclerreactivo);
                adaptadorreactivo adapter = new adaptadorreactivo(verreactivos.this, reactivo);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(verreactivos.this));
            }

            @Override
            public void onFailure(Call<List<itemreactivo>> call, Throwable t) {
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

                Call<List<itemreactivo>> call = apiInterface.getReactivo();
                call.enqueue(new Callback<List<itemreactivo>>() {
                    @Override
                    public void onResponse(Call<List<itemreactivo>> call, Response<List<itemreactivo>> response) {
                        reactivo = response.body();
                        RecyclerView recyclerView = findViewById(R.id.recyclerreactivo);
                        adaptadorreactivo adapter = new adaptadorreactivo(verreactivos.this, reactivo);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(verreactivos.this));
                    }

                    @Override
                    public void onFailure(Call<List<itemreactivo>> call, Throwable t) {
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

