package com.example.appsilvermin.tritudorista;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appsilvermin.R;
import com.example.appsilvermin.apiservice.ApiInterface;
import com.example.appsilvermin.apiservice.retrofet;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class usuariotritudorista extends AppCompatActivity  {
    Spinner spinner;




    private ApiInterface apiInterface;
    EditText ley, cantidad, hora;
    Button ingresar, datosingresados, equipoasignado;
    int dia, mes, anio;
    String fechaa;

//PARA SPINNER

    Spinner spinnerchancadora;
    ArrayList<String> chancadolist = new ArrayList<>();
    ArrayAdapter<String> chancadoadapter;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuariotritudorista);
    //    setContentView(R.layout.activity_usuariotritudorista);
//para spinner
 /*       requestQueue = Volley.newRequestQueue(this);
        spinner= findViewById(R.id.spinnerchancadora);
       */
        //fin
        spinner = findViewById(R.id.spinnerchancadora);
        ley = findViewById(R.id.leychancdo);
        cantidad = findViewById(R.id.cantidadchancadotrabajo);
        hora = findViewById(R.id.tiemochancadotrabajo);
        ingresar = findViewById(R.id.botoningresarchancadotrabajo);
        datosingresados = findViewById(R.id.botonverdatosingresadochancadotrabajo);
        equipoasignado = findViewById(R.id.botonverdatosotorgdo);


        //SINNER
        String [] opciones={"1","2","3"};
      ArrayAdapter<String> seccion=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,opciones);
      spinner.setAdapter(seccion);

        ProgressDialog progressDialog=new ProgressDialog(this);

            //ARRAY SIpNNER
      /*      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(usuariotritudorista.this, R.array.seccion
                    , android.R.layout.simple_spinner_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    System.out.println(adapterView.getItemAtPosition(i).toString());
                    String seccion = adapterView.getItemAtPosition(i).toString();
                    System.out.println(seccion);

                    //GET CHANCADO


                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });*/

       /* ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.seccion, android.R.layout.simple_spinner_item);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        String seccion = adapter;
*/
     /*    System.out.println(adapterView.getItemAtPosition(i).toString());
            String seccion = adapterView.getItemAtPosition(i).toString();
            System.out.println(seccion);
*/




//HASTA AQUI SPINNER



        
        
        
        
        
        
        
        
        
        
   /*     String url = "http://10.0.2.2:8000/api/insertarchancado";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray jsonArray) {
                try {

                    for(int i=0; i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String countryName = jsonObject.optString("nombre");
                        chancadolist.add(countryName);
                        chancadoadapter = new ArrayAdapter<>(usuariotritudoristatritudorista.this,
                                android.R.layout.simple_spinner_item, chancadolist);
                        chancadoadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(chancadoadapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        
        */


        datosingresados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        equipoasignado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresarconcentrado();
                ingresarchancadotrabajo();

            }

            public void ingresarchancadotrabajo() {
                apiInterface = retrofet.getApChancado().create(ApiInterface.class);
                Log.d(TAG, "initRecyclerView: init recyclerciew.");

                String ley1 = ley.getText().toString();
                String cantidad1 = cantidad.getText().toString();
                String tiempo1 = hora.getText().toString();

                Call<itemconcentrado> callw = apiInterface.getultimoConcentrado();
                callw.enqueue(new Callback<itemconcentrado>() {
                    @Override
                    public void onResponse(Call<itemconcentrado> call, retrofit2.Response<itemconcentrado> response) {

                        //chancadora = response.body();
                        try {//ARA IMAGEN
                            if (response.isSuccessful()) {
                                itemconcentrado u = (itemconcentrado) response.body();


                                String idconcentrados;
                                idconcentrados= u.getId();
                                //  itemchancadora listachancadora=response.body();
                                //String urliamgen="http://10.0.2.2:8000/"+p.getimaen+".jpg";
                              System.out.println(idconcentrados+"------");
                           //LLAMA AL SINNER
                                String seleccion=spinner.getSelectedItem().toString();
                                System.out.println(seleccion+"----00000");
                            //HASTA AQUI
//GET CHANCADO





                                 String URL = "http://10.0.2.2:8000/api/verchancado/"+seleccion;

                                RequestQueue requestQueue = Volley.newRequestQueue(usuariotritudorista.this);
                                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null,
                                        new com.android.volley.Response.Listener<JSONArray>() {
                                            @Override
                                            public void onResponse(JSONArray response) {
                                                //          JSONArray info = new JSONArray(response);
                                                try {
                                                    String idchancado = response.getJSONObject(0).getString("id");
                                                    System.out.println("sdfsfsdf" + idchancado);

//INSERTA DATOS CHNCADOTABAJO


                                                    progressDialog.show();
                                                    StringRequest request=new StringRequest(Request.Method.POST, "http://10.0.2.2:8000/api/insertarchancadotrabajo", new Response.Listener<String>() {
                                                        @Override
                                                        public void onResponse(String response) {
                                                            if (response.equalsIgnoreCase("Datos insertados")) {
                                                                Toast.makeText(getApplicationContext(), "datos ingresados", Toast.LENGTH_SHORT).show();
                                                                progressDialog.dismiss();
                                                            } else {
                                                                Toast.makeText(usuariotritudorista.this, response, Toast.LENGTH_SHORT).show();
                                                                progressDialog.dismiss();
                                                            }
                                                        }

                                                    }, new Response.ErrorListener() {
                                                        @Override
                                                        public void onErrorResponse(VolleyError error) {
                                                            Toast.makeText(usuariotritudorista.this, error.getMessage(),Toast.LENGTH_SHORT).show();;
                                                            progressDialog.dismiss();;
                                                        }
                                                    }){
                                                        @Override
                                                        protected Map<String, String> getParams() throws  AbstractMethodError{
                                                            Map<String, String>params=new HashMap<String, String>();
                                                            params.put("hora",tiempo1);
                                                            params.put("cantidadentrada",cantidad1);
                                                            params.put("idchancado",idchancado);
                                                            params.put("idconcentrados",idconcentrados);

                                                            //   params.put("horas",horas1);
                                                            return params;
                                                        }
                                                    };
                                                    RequestQueue requestQueue= Volley.newRequestQueue( usuariotritudorista.this);
                                                    requestQueue.add(request);
// HASTA AQUI CHANCADO TRABAJO

                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                    Toast.makeText(getApplicationContext(), "POR FAVOR VERIFIQUE LOS VALORES", Toast.LENGTH_SHORT).show();

                                                    System.out.println("no funciona");
                                                }
                                            }
                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        error.printStackTrace();
                                        Toast.makeText(getApplicationContext(), "POR FAVOR VERIFIQUE LOS VALORES", Toast.LENGTH_SHORT).show();

                                    }
                                });

                                requestQueue.add(jsonArrayRequest);


                      //HASTA AQUI
                            }

                        } catch (Exception ex) {
                            Toast.makeText(usuariotritudorista.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                            //  nombre.setText(dd);
                        }

                    }

                    @Override
                    public void onFailure(Call<itemconcentrado> call, Throwable t) {
                        System.out.println("furea de serviico");
                    }


                });

            }
        });
    }




            public void ingresarconcentrado() {


                String ley1 = ley.getText().toString().trim();
                String cantidad1 = cantidad.getText().toString().trim();
                String horas1 = hora.getText().toString().trim();


                //  String horas1=horas.getText().toString().trim();

                ProgressDialog progressDialog = new ProgressDialog(usuariotritudorista.this);
                if (ley1.isEmpty()) {
                    ley.setError("complete los campos");
                } else if (cantidad1.isEmpty()) {
                    cantidad.setError("complete los campos");
                } else if (horas1.isEmpty()) {
                    hora.setError("complete los campos");
                }
        /*    else if(horas1.isEmpty()){
                horas.setError("complete los campos");
            }*/
                else {


                    Calendar fecha = Calendar.getInstance();
                    dia = fecha.get(Calendar.DAY_OF_MONTH);
                    mes = fecha.get(Calendar.MONTH);
                    anio = fecha.get(Calendar.YEAR);
                    Date d = new Date();
                    CharSequence s = DateFormat.format("MMMM d, yyyy ", d.getTime());

                    fechaa = anio + "-" + mes + "-" + dia;//"2015-02-22";//
                    System.out.println(fechaa);


                    progressDialog.show();
                    StringRequest request = new StringRequest(Request.Method.POST, "http://10.0.2.2:8000/api/insertarconcentrado", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("Datos insertados")) {
                                Toast.makeText(getApplicationContext(), "datos ingresados", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            } else {
                                Toast.makeText(usuariotritudorista.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }

                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(usuariotritudorista.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            ;
                            progressDialog.dismiss();
                            ;
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AbstractMethodError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("fechaconcentrado", fechaa);
                            params.put("ley", ley1);
                            //    params.put("seccion",secccion1);

                            //   params.put("horas",horas1);
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(usuariotritudorista.this);
                    requestQueue.add(request);

                }
            }


}







   /*@Override
    public void onClick(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId() == R.id.spinnerchancadora){
            chancadolist.clear();
            String selectedCountry = adapterView.getSelectedItem().toString();
            String url = "http://10.0.2.2:8000/api/verchancado"+selectedCountry;
            requestQueue = Volley.newRequestQueue(this);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                    url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("cities");
                        for(int i=0; i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String cityName = jsonObject.optString("city_name");
                            chancadolist.add(cityName);
                            chancadoadapter = new ArrayAdapter<>(usuariotritudoristatritudorista.this,
                                    android.R.layout.simple_spinner_item, chancadolist);
                            chancadoadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinner.setAdapter(chancadoadapter);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            requestQueue.add(jsonObjectRequest);
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}*/

