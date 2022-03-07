package com.example.appsilvermin.administrador.adminverusuarios;


import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class modificarperfil extends AppCompatActivity {
    String url = "http://10.0.2.2:8000/api/modificarusuario/";
    private List<itemtrabajador> usuario;
    Context context;
    Button mod;
    TextView id;
    EditText nombre, apellidos, ciusuario, cargo, celular, passwordd;
    itemtrabajador u;

    Bundle datos;
    String idtra;
    ImageButton imagen;
    ApiInterface apiservice;
    RequestQueue requestQueue;
   private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificarperfil);

        mod = (Button) findViewById(R.id.botomodusuario);
        id = (TextView) findViewById(R.id.idetallemodusuario);



        nombre = (EditText) findViewById(R.id.nombredetallemodusuario);
        apellidos = (EditText) findViewById(R.id.apellidosdetallemodusuario);
        ciusuario = (EditText) findViewById(R.id.modmarca);
        cargo = (EditText) findViewById(R.id.cargodetallemodusuario);
        celular = (EditText) findViewById(R.id.celulardetallemodusuario);
        imagen = (ImageButton) findViewById(R.id.modimagenusuario);
        passwordd = (EditText) findViewById(R.id.contrasenadetallemodusuario);
        // passwordd= (TextView) findViewById(R.id.);


        datos = getIntent().getExtras();
        idtra = datos.getString("mod");
        id = (TextView) findViewById(R.id.idetallemodusuario);
        id.setText(idtra);

        apiInterface = retrofet.getApiClient().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiservice = retrofit.create(ApiInterface.class);

        modificarusuario();
        mostrarusuario();

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
                    protected Map<String, String>getParams() throws AuthFailureError{
                        Map<String,String> parametros=new HashMap<>();
                        //parametros.put("id",id.getText().toString());
                        parametros.put("ciusuario",ciusuario.getText().toString());
                        parametros.put("nombres",nombre.getText().toString());
                        parametros.put("apellidos",apellidos.getText().toString());
                    return parametros;
                    }
                };
                Intent intent = new Intent(view.getContext(), adminverusuarios.class);
                startActivityForResult(intent, 0);
                requestQueue = Volley.newRequestQueue(modificarperfil.this);
                requestQueue.add(stringRequest);

            }
        });
    }
    public void mostrarusuario() {
        Call<itemtrabajador> call = apiInterface.getUsuarioxid(idtra);
        call.enqueue(new Callback<itemtrabajador>() {
            @Override
            public void onResponse(Call<itemtrabajador> call, Response<itemtrabajador> response) {
                try {//ARA IMAGEN
                    if (response.isSuccessful()) {
                        itemtrabajador u = (itemtrabajador) response.body();
                        //  itemtrabajador listausuario=response.body();
                        //String urliamgen="http://10.0.2.2:8000/"+p.getimaen+".jpg";
                        // imagen.setImageIcon(u.getImagen());

                        nombre.setText(u.getNombres());
                        apellidos.setText(u.getApellidos());
                        ciusuario.setText(u.getCiusuario());
                        cargo.setText(u.getCargo());
                        celular.setText(u.getCelular());
                        passwordd.setText(u.getPasswordd());
                        //   Glide.with(getApplication()).load(urlimagen).into(imagen);

                    }

                } catch (Exception ex) {
                    Toast.makeText(modificarperfil.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    //  nombre.setText(dd);
                }

            }

            @Override
            public void onFailure(Call<itemtrabajador> call, Throwable t) {

            }

        });
    }


public void  modificarusuario(){
    Call<itemtrabajador> call = apiInterface.putUsuario(idtra);
    call.enqueue(new Callback<itemtrabajador>() {
        @Override
        public void onResponse(Call<itemtrabajador> call, Response<itemtrabajador> response) {
            try {//ARA IMAGEN
                if (response.isSuccessful()) {
                    itemtrabajador u = (itemtrabajador) response.body();
                    //  itemtrabajador listausuario=response.body();
                    //String urliamgen="http://10.0.2.2:8000/"+p.getimaen+".jpg";
                    // imagen.setImageIcon(u.getImagen());

                    nombre.setText(u.getNombres());
                    apellidos.setText(u.getApellidos());
                    ciusuario.setText(u.getCiusuario());
                    cargo.setText(u.getCargo());
                    celular.setText(u.getCelular());
                    passwordd.setText(u.getPasswordd());
                    //   Glide.with(getApplication()).load(urlimagen).into(imagen);


                }

            } catch (Exception ex) {
                Toast.makeText(modificarperfil.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                //  nombre.setText(dd);
            }

        }

        @Override
        public void onFailure(Call<itemtrabajador> call, Throwable t) {

        }

    });

}


}

      /*  mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   // modificarusuarios();
                if(id.getText().equals("") || nombre.getText().equals("") || apellidos.getText().equals("")) {
                    Toast.makeText(modificarperfil.this, "Se deben de llenar los campos", Toast.LENGTH_SHORT).show();
                } else {
                    modificarusuarios( id.getText(), nombre.getText(), apellidos.getText());
                }
            }
        });

    }

    private void modificarusuarios() {
        itemtrabajador itemtrabajador = new itemtrabajador("","","", "","","","","" );

        Call<itemtrabajador> call= apiInterface.putUsuario(idtra);
        call.enqueue(new Callback<com.example.silvermin.itemtrabajador>() {
            @Override
            public void onResponse(Call<com.example.silvermin.itemtrabajador> call, Response<com.example.silvermin.itemtrabajador> response) {
                if(response.isSuccessful()){

                    itemtrabajador  u= (itemtrabajador) response.body();
                    //  itemtrabajador listausuario=response.body();
                    //String urliamgen="http://10.0.2.2:8000/"+p.getimaen+".jpg";
                    nombre.setText(u.getNombres());
                    apellidos.setText(u.getApellidos());
                    ciusuario.setText(u.getCiusuario());
                    cargo.setText(u.getCargo());
                    celular.setText(u.getCelular());
                    passwordd.setText(u.getPasswordd());
                    //   Glide.with(getApplication()).load(urlimagen).into(imagen);


                }
            }

            @Override
            public void onFailure(Call<com.example.silvermin.itemtrabajador> call, Throwable t) {

            }
        });
    }


}*/
