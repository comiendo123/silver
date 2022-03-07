package com.example.appsilvermin.molinero.ingresarmolienda;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appsilvermin.R;
import com.example.appsilvermin.almacenero.reactivo.insertarreactivos.adaptadorreactivo;
import com.example.appsilvermin.almacenero.reactivo.insertarreactivos.itemreactivo;
import com.example.appsilvermin.apiservice.ApiInterface;
import com.example.appsilvermin.apiservice.retrofet;
import com.example.appsilvermin.molinero.ingresarmolienda.moliendareactivos.adaptadorreactivos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class insertarmoliendas extends AppCompatActivity {

    EditText cantidad, horas;
    Spinner spisector, spireactivo;
    TextView idd, cantidads;
    Bundle datos;
    Button ingresar;


    RequestQueue requestQueue;
    ApiInterface apiInterface,apiInterfaces;
    String id, nombre;
    EditText sector;

    private List<itemreactivo> reactivo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertarmoliendas);

        sector = findViewById(R.id.edittextsector);
        cantidad = findViewById(R.id.cantidadvermolienda);
        horas = findViewById(R.id.horavermoliendas);
        //  spisector = findViewById(R.id.sectorvermoliendas);
        //  spireactivo = findViewById(R.id.reactivosvermoliendas);
        cantidads = findViewById(R.id.cantidadsverdlotacion);
        ingresar = findViewById(R.id.ingresarmolienda);
        datos = getIntent().getExtras();
        requestQueue = Volley.newRequestQueue(insertarmoliendas.this);
        String ids = datos.getString("idchancadotrabajo");



        idd = findViewById(R.id.idvermolienda);
        idd.setText(ids);
        System.out.println(ids + "iiiiddd");

        String idmolienda = datos.getString("idmolienda");
        idd = (TextView) findViewById(R.id.idvermolienda);
        idd.setText(idmolienda);
        System.out.println(idmolienda + "ioooooiiiddd");

        String idconcentrado = datos.getString("id");
        //  idd = (TextView) findViewById(idvermolienda);
        //   idd.setText(ids);
        System.out.println(idconcentrado + "xddd");


//LISTA REACTIVOS

        apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<List<itemreactivo>> call = apiInterface.getReactivo();
        call.enqueue(new Callback<List<itemreactivo>>() {
            @Override
            public void onResponse(Call<List<itemreactivo>> call, Response<List<itemreactivo>> response) {
                reactivo = response.body();
                RecyclerView recyclerView = findViewById(R.id.recyclerviewlistareactivos);
                adaptadorreactivos adapter = new adaptadorreactivos(insertarmoliendas.this, reactivo);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(insertarmoliendas.this));
                adapter.enviarDatos(idconcentrado);
            }

            @Override
            public void onFailure(Call<List<itemreactivo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Toast por defecto", Toast.LENGTH_SHORT);

            }
        });


//HASTA AQUI




        apiInterface = retrofet.getApiClient().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<itemtotalchancado> calle = apiInterface.getChancadototales(ids);
        //  adapter = new ArrayAdapter<listadaptadorusuarios>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, usuario);

        calle.enqueue(new Callback<itemtotalchancado>() {
            @Override
            public void onResponse(Call<itemtotalchancado> call, Response<itemtotalchancado> response) {

                //usuario = response.body();
                try {//ARA IMAGEN
                    if (response.isSuccessful()) {
                        itemtotalchancado u = (itemtotalchancado) response.body();
                        id = (u.getIdchancado());
                        cantidads.setText(u.getIdchancado());
                        nombre = (u.getNombre());

                        System.out.println(apiInterface);
                        System.out.println(nombre);
                    }

                } catch (Exception ex) {
                    Toast.makeText(insertarmoliendas.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    //  nombre.setText(dd);
                }

            }

            @Override
            public void onFailure(Call<itemtotalchancado> call, Throwable t) {
                System.out.println("sdsdsdsdsd");
            }


        });





        ingresar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String horaa = horas.getText().toString();
                String caant = cantidad.getText().toString();
                String sectoor = sector.getText().toString();
              /* PARA SECTOR


                //VER MOLIENDA POR SECCION
                apiInterface = retrofit.getApiClient().create(apiservice.class);
                Log.d(TAG, "initRecyclerView: init recyclerciew.");

                Call<itemmolienda> calles = apiInterface.getMoliendaxseccion(sectoor);
                //  adapter = new ArrayAdapter<listadaptadorusuarios>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, usuario);

                calles.enqueue(new Callback<itemmolienda>() {
                    @Override
                    public void onResponse(Call<itemmolienda> call, Response<itemmolienda> response) {

                        //usuario = response.body();
                        try {//ARA IMAGEN
                            if (response.isSuccessful()) {
                                itemmolienda u = (itemmolienda) response.body();
                                id = (u.getId());
                                //        cantidads.setText(u.getId());
                                //  nombre = (u.getNombre());

                                System.out.println(apiInterface);
                                System.out.println(id+"aaaaaaaa");
                            }

                        } catch (Exception ex) {
                            Toast.makeText(insertarmoliendas.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                            //  nombre.setText(dd);
                        }

                    }

                    @Override
                    public void onFailure(Call<itemmolienda> call, Throwable t) {
                        System.out.println("caterrr");
                    }


                });*/
//HASTA AQUI


                ProgressDialog progressDialog = new ProgressDialog(insertarmoliendas.this);
                progressDialog.show();
                StringRequest request = new StringRequest(Request.Method.POST, "http://10.0.2.2:8000/api/insertarmoliendatrabajo/", new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("Datos insertados")) {
                            Toast.makeText(insertarmoliendas.this, "datos ingresados", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        } else {
                            Toast.makeText(insertarmoliendas.this, response, Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }

                }, new com.android.volley.Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(insertarmoliendas.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        ;
                        progressDialog.dismiss();
                        ;
                    }
                }) {//AGREGAR VALORES
                    @Override
                    protected Map<String, String> getParams() throws AbstractMethodError {
                        Map<String, String> params = new HashMap<String, String>();
                        //  params.put("id", null);
                        params.put("hora", horaa);
                        params.put("cantidadentrada", caant);
                        params.put("idmolienda", sectoor);
                        params.put("idconcentrados", idconcentrado);

                        System.out.println("sisirve" +"+"+ idconcentrado+"+"+horaa+"+"+caant+"+"+sectoor);
                        return params;

                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(insertarmoliendas.this);

                requestQueue.add(request);
                //   return idconcentrado;


            }
        });
    }
    public void enviarDatos( String idconcentrado) {


        idconcentrado = idconcentrado;
    }

}