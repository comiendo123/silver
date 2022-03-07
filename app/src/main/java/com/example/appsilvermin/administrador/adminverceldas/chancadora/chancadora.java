package com.example.appsilvermin.administrador.adminverceldas.chancadora;

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

public class chancadora extends AppCompatActivity {


    SwipeRefreshLayout swipeRefreshLayout;
    String url = "http://10.0.2.2:8000/api/informes/";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private List<itemchancadora> chancadora = new ArrayList<>();
    private ApiInterface apiInterface;
    ImageView ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chancadora);


        recyclerView = findViewById(R.id.recyclerchancadora);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        swipeRefreshLayout = this.findViewById(R.id.swipe);
        ingresar = this.findViewById(R.id.agregarchancadora);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), agregarchancadora.class);
                startActivityForResult(intent, 0);
            }
        });


        apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<List<itemchancadora>> call = apiInterface.getChancado();
        call.enqueue(new Callback<List<itemchancadora>>() {
            @Override
            public void onResponse(Call<List<itemchancadora>> call, retrofit2.Response<List<itemchancadora>> response) {
                chancadora = response.body();
                RecyclerView recyclerView = findViewById(R.id.recyclerchancadora);
                adaptdorchancadora adapter = new adaptdorchancadora(chancadora.this, chancadora);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(chancadora.this));
            }

            @Override
            public void onFailure(Call<List<itemchancadora>> call, Throwable t) {
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

                Call<List<itemchancadora>> call = apiInterface.getChancado();
                call.enqueue(new Callback<List<itemchancadora>>() {
                    @Override
                    public void onResponse(Call<List<itemchancadora>> call, Response<List<itemchancadora>> response) {
                        chancadora = response.body();
                        RecyclerView recyclerView = findViewById(R.id.recyclerchancadora);
                        adaptdorchancadora adapter = new adaptdorchancadora(chancadora.this, chancadora);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(chancadora.this));
                    }

                    @Override
                    public void onFailure(Call<List<itemchancadora>> call, Throwable t) {
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

