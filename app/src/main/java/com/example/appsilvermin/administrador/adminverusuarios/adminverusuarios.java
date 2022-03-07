package com.example.appsilvermin.administrador.adminverusuarios;

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
import com.example.appsilvermin.apiservice.ApiInterface;
import com.example.appsilvermin.apiservice.retrofet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class adminverusuarios extends AppCompatActivity {



    SwipeRefreshLayout swipeRefreshLayout;
    String url = "http://10.0.2.2:8000/api/informes/";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private adaptadortrabajador adapter;
    private List<itemtrabajador> usuario = new ArrayList<>();
    private ApiInterface apiInterface;
    ImageView ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminverusuarios);



        recyclerView = findViewById(R.id.recyclerusuario);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        swipeRefreshLayout = this.findViewById(R.id.swipe);
         ingresar = this.findViewById(R.id.agregarusuario);



       ingresar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(v.getContext(), agregartrabajador.class);
               startActivityForResult(intent, 0);
           }
       });


        apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<List<itemtrabajador>> call = apiInterface.getUsuario();
        call.enqueue(new Callback<List<itemtrabajador>>() {
            @Override
            public void onResponse(Call<List<itemtrabajador>> call, retrofit2.Response<List<itemtrabajador>> response) {
                usuario = response.body();
                RecyclerView recyclerView = findViewById(R.id.recyclerusuario);
                adaptadortrabajador adapter = new adaptadortrabajador(adminverusuarios.this, usuario );
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(adminverusuarios.this));
            }

            @Override
            public void onFailure(Call<List<itemtrabajador>> call, Throwable t) {
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

                Call<List<itemtrabajador>> call = apiInterface.getUsuario();
                call.enqueue(new Callback<List<itemtrabajador>>() {
                    @Override
                    public void onResponse(Call<List<itemtrabajador>> call, Response<List<itemtrabajador>> response) {
                        usuario = response.body();
                        RecyclerView recyclerView = findViewById(R.id.recyclerusuario);
                        adaptadortrabajador adapter = new adaptadortrabajador(adminverusuarios.this, usuario);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(adminverusuarios.this));
                    }

                    @Override
                    public void onFailure(Call<List<itemtrabajador>> call, Throwable t) {
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