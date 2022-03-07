package com.example.appsilvermin.molinero;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.appsilvermin.R;
import com.example.appsilvermin.apiservice.ApiInterface;
import com.example.appsilvermin.apiservice.retrofet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class usuariomolinero extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    String urlflotacion = "http://10.0.2.2:8000/api/flotacion";
    String urlflotaciontrabajo = "http://10.0.2.2:8000/api/flotaciontrabajo";
    String urlconcentrado = "http://10.0.2.2:8000/api/concentrado";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private adaptadorchancadototal adapter;
    private List<itemchancadototal> flotacion = new ArrayList<>();
 
    private ApiInterface apiInterface;
    // ImageView ingresar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuariomolinero);

        recyclerView = findViewById(R.id.recyclerchancadototal);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        swipeRefreshLayout = this.findViewById(R.id.swipeflotacion);
        //  ingresar = this.findViewById(R.id.ingresarcelda);
        //    ingresar.setOnClickListener(new View.OnClickListener() {
      /*      @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), administradoragregarcelda.class);
                startActivityForResult(intent, 0);
            }
        });
*/

        apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<List<itemchancadototal>> call = apiInterface.getChancadototal();
        call.enqueue(new Callback<List<itemchancadototal>>() {
            @Override
            public void onResponse(Call<List<itemchancadototal>> call, Response<List<itemchancadototal>> response) {
                flotacion = response.body();
                RecyclerView recyclerView = findViewById(R.id.recyclerchancadototal);
                adaptadorchancadototal adapter = new adaptadorchancadototal(usuariomolinero.this, flotacion);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(usuariomolinero.this));

            }

            @Override
            public void onFailure(Call<List<itemchancadototal>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Toast por defecto", Toast.LENGTH_SHORT);

            }
        });
//usuariomolinero






        ///ARA REFRESCAR

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                apiInterface = retrofet.getApChancado().create(ApiInterface.class);
                Log.d(TAG, "initRecyclerView: init recyclerciew.");

                Call<List<itemchancadototal>> call = apiInterface.getChancadototal();
                call.enqueue(new Callback<List<itemchancadototal>>() {
                    @Override
                    public void onResponse(Call<List<itemchancadototal>> call, Response<List<itemchancadototal>> response) {
                        flotacion = response.body();
                        RecyclerView recyclerView = findViewById(R.id.recyclerchancadototal);
                        adaptadorchancadototal adapter = new adaptadorchancadototal(usuariomolinero.this, flotacion);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(usuariomolinero.this));
                    }

                    @Override
                    public void onFailure(Call<List<itemchancadototal>> call, Throwable t) {
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
