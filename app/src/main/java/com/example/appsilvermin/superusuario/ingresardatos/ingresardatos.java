package com.example.appsilvermin.superusuario.ingresardatos;

import static android.content.ContentValues.TAG;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appsilvermin.R;
import com.example.appsilvermin.apiservice.ApiInterface;
import com.example.appsilvermin.apiservice.retrofet;
import com.example.appsilvermin.superusuario.verdatos.modelproceso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;

public class ingresardatos extends AppCompatActivity {
    Button ingresarproceso;
    EditText fecha, ley, cantidad;
    TextView ultimo,hora;
    SwipeRefreshLayout swipeRefreshLayout;
    String url = "http://10.0.2.2:8000/api/verultimo/";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    List<modelproceso> verdato = new ArrayList<>();
    private ApiInterface apiInterface;

    String dia, mes, anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresardatos);
        fecha = findViewById(R.id.editfecha);
        ultimo = findViewById(R.id.ultimo);
    hora=findViewById(R.id.hora);
Date dates = new Date();
        ley=findViewById(R.id.edittextley);
        cantidad=findViewById(R.id.edittextcantidad);
        ingresarproceso=findViewById(R.id.registrarproceso);

        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);

                updateCalendar();
            }

            private void updateCalendar() {
                String Format = "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.CANADA);
                fecha.setText(sdf.format(calendar.getTime()));
            }
        };
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ingresardatos.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        recyclerView = findViewById(R.id.reciclerultimo);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        swipeRefreshLayout = this.findViewById(R.id.swipe);

//hastaaqui

        String url = "http://10.0.2.2:8000/api/verultimo";

        RequestQueue requestQueue = Volley.newRequestQueue(ingresardatos.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            String idconcentrados = response.getString("id").toString().trim();
                            String anio = response.getString("anio").toString().trim();
                            String mes = response.getString("mes").toString().trim();
                            String dia = response.getString("dia").toString().trim();
                            System.out.println(idconcentrados + "--0000000" + anio + "--" + mes + "---" + dia);
                            ultimo.setText(dia + "-" + mes + "-" + anio);

                            //  ProgressDialog progressDialog = new ProgressDialog(ingresardatos.this);
                            // progressDialog.show();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);


        apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<List<modelproceso>> call = apiInterface.getProcesoDesc();
        call.enqueue(new Callback<List<modelproceso>>() {
            @Override
            public void onResponse(Call<List<modelproceso>> call, retrofit2.Response<List<modelproceso>> response) {
                verdato = response.body();
                RecyclerView recyclerView = findViewById(R.id.reciclerultimo);
                adaptadorultimo adapter = new adaptadorultimo(ingresardatos.this, verdato);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(ingresardatos.this));
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

                apiInterface = retrofet.getApChancado().create(ApiInterface.class);
                Log.d(TAG, "initRecyclerView: init recyclerciew.");

                Call<List<modelproceso>> call = apiInterface.getProcesoDesc();
                call.enqueue(new Callback<List<modelproceso>>() {
                    @Override
                    public void onResponse(Call<List<modelproceso>> call, retrofit2.Response<List<modelproceso>> response) {
                        verdato = response.body();
                        RecyclerView recyclerView = findViewById(R.id.reciclerultimo);
                        adaptadorultimo adapter = new adaptadorultimo(ingresardatos.this, verdato);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(ingresardatos.this));
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


     //   private void insertar(){
//HORA
//
SimpleDateFormat h=new SimpleDateFormat("h:mm a");
String ahora = h.format(dates);
hora.setText(ahora);



       ingresarproceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ddd=fecha.getText().toString().trim();   System.out.println(ddd);
                String ley1 = ley.getText().toString().trim();
                String cantidadentrada1 = cantidad.getText().toString().trim();
             //   String cantidadentrada1 = cantidad.getText().toString().trim();
                String hora1 = hora.getText().toString().trim();
           ProgressDialog progressDialog=new ProgressDialog(ingresardatos.this);
            if(ley1.isEmpty()){
                ley.setError("complete los campos");
            }
            else if(cantidadentrada1.isEmpty()){
                cantidad.setError("complete los campos");
            } else if(ddd.isEmpty()){
                fecha.setError("complete los campos");
            }
            else{
                StringTokenizer sep= new StringTokenizer("/");
                String[] sepa=ddd.split("/");
                String da = sepa[0];
                String me = sepa[1];
                String an = sepa[2];
                System.out.println(da);
                System.out.println(me);
                System.out.println(an);
                progressDialog.show();
                StringRequest request=new StringRequest(Request.Method.POST, "http://10.0.2.2:8000/api/insertarproceso", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("Datos insertados")) {
                            Toast.makeText(getApplicationContext(), "datos ingresados", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        } else {
                            Toast.makeText(ingresardatos.this, response, Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ingresardatos.this, error.getMessage(),Toast.LENGTH_SHORT).show();;
                        progressDialog.dismiss();;
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws  AbstractMethodError{
                        Map<String, String>params=new HashMap<String, String>();
                        params.put("anio",an);
                        params.put("mes",da);
                        params.put("dia",me);
                        params.put("cantidadentrada",cantidadentrada1);
                        params.put("hora",ahora);
                        params.put("ley",ley1);

                        //   params.put("horas",horas1);
                        return params;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue( ingresardatos.this);
                requestQueue.add(request);

            }
        }

    });
}


        }





