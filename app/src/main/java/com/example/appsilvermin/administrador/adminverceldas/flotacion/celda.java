package com.example.appsilvermin.administrador.adminverceldas.flotacion;

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

public class celda extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    String url = "http://10.0.2.2:8000/api/informes/";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private adaptadorcelda adapter;
    private List<itemcelda> celda = new ArrayList<>();
    private ApiInterface apiInterface;
    ImageView ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celda);


        recyclerView = findViewById(R.id.recyclercelda);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        swipeRefreshLayout = this.findViewById(R.id.swipe);
        ingresar = this.findViewById(R.id.agregarcelda);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), agregarcelda.class);
                startActivityForResult(intent, 0);
            }
        });


        apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<List<itemcelda>> call = apiInterface.getCelda();
        call.enqueue(new Callback<List<itemcelda>>() {
            @Override
            public void onResponse(Call<List<itemcelda>> call, retrofit2.Response<List<itemcelda>> response) {
                celda = response.body();
                RecyclerView recyclerView = findViewById(R.id.recyclercelda);
                adaptadorcelda adapter = new adaptadorcelda(celda.this, celda);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(celda.this));
            }

            @Override
            public void onFailure(Call<List<itemcelda>> call, Throwable t) {
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

                Call<List<itemcelda>> call = apiInterface.getCelda();
                call.enqueue(new Callback<List<itemcelda>>() {
                    @Override
                    public void onResponse(Call<List<itemcelda>> call, Response<List<itemcelda>> response) {
                        celda = response.body();
                        RecyclerView recyclerView = findViewById(R.id.recyclercelda);
                        adaptadorcelda adapter = new adaptadorcelda(celda.this, celda);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(celda.this));
                    }

                    @Override
                    public void onFailure(Call<List<itemcelda>> call, Throwable t) {
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
