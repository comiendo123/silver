package com.example.appsilvermin.administrador.adminverceldas.flotacion;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appsilvermin.R;
import com.example.appsilvermin.apiservice.ApiInterface;
import com.example.appsilvermin.apiservice.retrofet;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class modificarcelda extends AppCompatActivity {

    String url = "http://10.0.2.2:8000/api/modificarflotacion/";
    Button mod;
    TextView id,cantidadhoras;
    EditText nombre, descripcion, seccion;


    Bundle datos;
    String idtra;
    ImageButton imagen;
    ApiInterface apiservice;
    RequestQueue requestQueue;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificarcelda);

        mod = (Button) findViewById(R.id.botomodcelda);
        id = (TextView) findViewById(R.id.idetallemodcelda);



        nombre = (EditText) findViewById(R.id.nombremodificarcelda);
        descripcion = (EditText) findViewById(R.id.ndescripcionemodcelda);
        seccion = (EditText) findViewById(R.id.seccionmodcelda);
        cantidadhoras = (TextView) findViewById(R.id.cantidadhoraschancadira);

        // passwordd= (TextView) findViewById(R.id.);


        datos = getIntent().getExtras();
        idtra = datos.getString("mod");
        id = (TextView) findViewById(R.id.idetallemodcelda);
        id.setText(idtra);

        apiInterface = retrofet.getApiClient().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiservice = retrofit.create(ApiInterface.class);

        modificarcelda();
        mostrarcelda();

        mod.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                StringRequest stringRequest=new StringRequest(Request.Method.PUT, url+idtra, new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "se modifico", Toast.LENGTH_SHORT).show();
                    }
                }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
                    }

                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parametros=new HashMap<>();
                        //parametros.put("id",id.getText().toString());
                        parametros.put("nombre",nombre.getText().toString());
                        parametros.put("descripcion",descripcion.getText().toString());
                        parametros.put("seccion",seccion.getText().toString());
                        return parametros;
                    }
                };
                Intent intent = new Intent(view.getContext(), celda.class);
                startActivityForResult(intent, 0);
                requestQueue = Volley.newRequestQueue(modificarcelda.this);
                requestQueue.add(stringRequest);

            }
        });
    }
    public void mostrarcelda() {
        Call<itemcelda> call = apiInterface.getCeldaxid(idtra);
        call.enqueue(new Callback<itemcelda>() {
            @Override
            public void onResponse(Call<itemcelda> call, Response<itemcelda> response) {
                try {//ARA IMAGEN
                    if (response.isSuccessful()) {
                        itemcelda u = (itemcelda) response.body();
                        //  itemcelda listacelda=response.body();
                        //String urliamgen="http://10.0.2.2:8000/"+p.getimaen+".jpg";
                        // imagen.setImageIcon(u.getImagen());

                        nombre.setText(u.getNombre());
                        descripcion.setText(u.getDescripcion());
                        seccion.setText(u.getSeccion());
                        id.setText(u.getId());
                        cantidadhoras.setText(u.getCantidadhoras());


                    }

                } catch (Exception ex) {
                    Toast.makeText(modificarcelda.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    //  nombre.setText(dd);
                }

            }

            @Override
            public void onFailure(Call<itemcelda> call, Throwable t) {

            }

        });
    }


    public void  modificarcelda(){
        Call<itemcelda> call = apiInterface.putCelda(idtra);
        call.enqueue(new Callback<itemcelda>() {
            @Override
            public void onResponse(Call<itemcelda> call, Response<itemcelda> response) {
                try {//ARA IMAGEN
                    if (response.isSuccessful()) {
                        itemcelda u = (itemcelda) response.body();
                        //  itemcelda listacelda=response.body();
                        //String urliamgen="http://10.0.2.2:8000/"+p.getimaen+".jpg";
                        // imagen.setImageIcon(u.getImagen());



                        nombre.setText(u.getNombre());
                        descripcion.setText(u.getDescripcion());
                        seccion.setText(u.getSeccion());
                        id.setText(u.getId());
                        cantidadhoras.setText(u.getCantidadhoras());
                        //   Glide.with(getApplication()).load(urlimagen).into(imagen);


                    }

                } catch (Exception ex) {
                    Toast.makeText(modificarcelda.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    //  nombre.setText(dd);
                }

            }

            @Override
            public void onFailure(Call<itemcelda> call, Throwable t) {

            }

        });

    }


}

      /*  mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   // modificarceldas();
                if(id.getText().equals("") || nombre.getText().equals("") || apellidos.getText().equals("")) {
                    Toast.makeText(modificarperfil.this, "Se deben de llenar los campos", Toast.LENGTH_SHORT).show();
                } else {
                    modificarceldas( id.getText(), nombre.getText(), apellidos.getText());
                }
            }
        });

    }

    private void modificarceldas() {
        itemcelda itemcelda = new itemcelda("","","", "","","","","" );

        Call<itemcelda> call= apiInterface.putcelda(idtra);
        call.enqueue(new Callback<com.example.silvermin.itemcelda>() {
            @Override
            public void onResponse(Call<com.example.silvermin.itemcelda> call, Response<com.example.silvermin.itemcelda> response) {
                if(response.isSuccessful()){

                    itemcelda  u= (itemcelda) response.body();
                    //  itemcelda listacelda=response.body();
                    //String urliamgen="http://10.0.2.2:8000/"+p.getimaen+".jpg";
                    nombre.setText(u.getNombres());
                    apellidos.setText(u.getApellidos());
                    cicelda.setText(u.getCicelda());
                    cargo.setText(u.getCargo());
                    celular.setText(u.getCelular());
                    passwordd.setText(u.getPasswordd());
                    //   Glide.with(getApplication()).load(urlimagen).into(imagen);


                }
            }

            @Override
            public void onFailure(Call<com.example.silvermin.itemcelda> call, Throwable t) {

            }
        });
    }


}*/
