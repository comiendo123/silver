package com.example.appsilvermin.almacenero.equipo.insertarequipo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appsilvermin.R;
import com.example.appsilvermin.almacenero.equipo.verequipos;

import java.util.HashMap;
import java.util.Map;

public class insertarequipo extends AppCompatActivity {

    EditText nombre, marca, cantidad, talla;

    Button ingresar, cancelar;


  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertarequipo);

        //  id = this.findViewById(R.id.modmarca);
        nombre = this.findViewById(R.id.nombreequipo);
        marca = this.findViewById(R.id.marcaequipo);
        talla =this.findViewById(R.id.tallaequipo);
        cantidad = this.findViewById(R.id.cantidadequipo);
        /*celular = this.findViewById(R.id.celulardetallechancadora);
        passwordd = this.findViewById(R.id.ingresarcontrasena);
*/


        ingresar = findViewById(R.id.botoningresarequipo);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), verequipos.class);
                startActivityForResult(intent, 0);
                insertar();
            }
        });
    }

    private void insertar() {

        String nombre1 = nombre.getText().toString().trim();
        String talla1 = talla.getText().toString().trim();
        String marca1 = marca.getText().toString().trim();
        String cantidad1 = cantidad.getText().toString().trim();

        //  String horas1=horas.getText().toString().trim();

        ProgressDialog progressDialog = new ProgressDialog(this);
        if (nombre1.isEmpty()) {
            nombre.setError("complete los campos");
        } else if (talla1.isEmpty()) {
            talla.setError("complete los campos");
        } else if (marca1.isEmpty()) {
            marca.setError("complete los campos");

        } else if (cantidad1.isEmpty()) {
            cantidad.setError("complete los campos");
        }
        /*    else if(horas1.isEmpty()){
                horas.setError("complete los campos");
            }*/
        else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://10.0.2.2:8000/api/insertarequipo", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Datos insertados")) {
                        Toast.makeText(getApplicationContext(), "datos ingresados", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    } else {
                        Toast.makeText(insertarequipo.this, response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(insertarequipo.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    ;
                    progressDialog.dismiss();
                    ;
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AbstractMethodError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("nombre", nombre1);
                    params.put("talla", talla1);
                    params.put("marca", cantidad1);
                    params.put("cantidad", cantidad1);
                    //   params.put("horas",horas1);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(insertarequipo.this);
            requestQueue.add(request);

        }
    }
}

