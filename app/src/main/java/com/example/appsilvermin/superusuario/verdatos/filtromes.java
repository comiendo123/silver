package com.example.appsilvermin.superusuario.verdatos;
import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appsilvermin.R;
import com.example.appsilvermin.apiservice.ApiInterface;
import com.example.appsilvermin.apiservice.retrofet;
import com.example.appsilvermin.superusuario.verdatos.adaptadorproceso;
import com.example.appsilvermin.superusuario.verdatos.filtroanio;
import com.example.appsilvermin.superusuario.verdatos.modelproceso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class filtromes extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    String url = "http://10.0.2.2:8000/api/informes/";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private List<modelproceso> filtromes = new ArrayList<>();
    private ApiInterface apiInterface;
    ImageView ingresar;

    Button verdia,vermes,veranio;
    Spinner dia, mes;
    EditText anio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtromes);

        dia=findViewById(R.id.spinnerdia);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.dia, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dia.setAdapter(adapter);


        mes=findViewById(R.id.spinnermes);
        ArrayAdapter<CharSequence> adaptero = ArrayAdapter.createFromResource(this, R.array.mes, android.R.layout.simple_spinner_item);
        adaptero.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mes.setAdapter(adaptero);

        anio=findViewById(R.id.textviewanio);
        verdia=findViewById(R.id.filtrodia);
        vermes=findViewById(R.id.filtromes);
        veranio=findViewById(R.id.filtroanio);



        vermes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), filtromes.class);
                startActivityForResult(intent, 0);
            }
        });
        veranio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), filtroanio.class);
                startActivityForResult(intent, 0);
            }
        });







        recyclerView = findViewById(R.id.recyclerdia);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        swipeRefreshLayout = this.findViewById(R.id.swipe);
        //   ingresar = this.findViewById(R.id.agregarfiltromes);


           /* ingresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), agregarfiltromes.class);
                    startActivityForResult(intent, 0);
                }
            });
*/

       /* apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<List<modelproceso>> call = apiInterface.getProceso();
        call.enqueue(new Callback<List<modelproceso>>() {
            @Override
            public void onResponse(Call<List<modelproceso>> call, retrofit2.Response<List<modelproceso>> response) {
                filtromes = response.body();
                RecyclerView recyclerView = findViewById(R.id.recyclerdia);
                adaptadorproceso adapter = new adaptadorproceso(filtromes.this, filtromes);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(filtromes.this));
            }

            @Override
            public void onFailure(Call<List<modelproceso>> call, Throwable t) {
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

                Call<List<modelproceso>> call = apiInterface.getProceso();
                call.enqueue(new Callback<List<modelproceso>>() {
                    @Override
                    public void onResponse(Call<List<modelproceso>> call, Response<List<modelproceso>> response) {
                        filtromes = response.body();
                        RecyclerView recyclerView = findViewById(R.id.recyclerdia);
                        adaptadorproceso adapter = new adaptadorproceso(filtromes.this, filtromes);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(filtromes.this));
                    }

                    @Override
                    public void onFailure(Call<List<modelproceso>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Toast por defecto", Toast.LENGTH_SHORT);

                    }
                });


                //cierre de refresh
                swipeRefreshLayout.setRefreshing(false);

            }


        });
//hastaaqui
*/
    }
}


