package com.example.appsilvermin.almacenero.reactivo.insertarreactivos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appsilvermin.R;
import com.example.appsilvermin.administrador.adminverceldas.chancadora.chancadora;

import java.util.HashMap;
import java.util.Map;

public class insertarreactivos extends AppCompatActivity {
    
    
    EditText  nombre, descripcion, cantidad;

    Button ingresar, cancelar;
   

    private static final int REQUEST_PERMISSION_CAMERA = 100;
    private static final int REQUEST_TAKE_PHOTO = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertarreactivos);

        //  id = this.findViewById(R.id.modmarca);
        nombre = this.findViewById(R.id.nombrereactivo);
        descripcion = this.findViewById(R.id.descipcionreactivos);
        cantidad = this.findViewById(R.id.cantidadreactivos);
        /*celular = this.findViewById(R.id.celulardetallechancadora);
        passwordd = this.findViewById(R.id.ingresarcontrasena);
*/


        ingresar = findViewById(R.id.botoningresarreactivos);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), verreactivos.class);
                startActivityForResult(intent, 0);
                insertar();
            }
        });
    }

    private void insertar() {

        String nombre1 = nombre.getText().toString().trim();
        String descripcion1 = descripcion.getText().toString().trim();
        String cantidad1 = cantidad.getText().toString().trim();


        //  String horas1=horas.getText().toString().trim();

        ProgressDialog progressDialog = new ProgressDialog(this);
        if (nombre1.isEmpty()) {
            nombre.setError("complete los campos");
        } else if (descripcion1.isEmpty()) {
            descripcion.setError("complete los campos");
        } else if (cantidad1.isEmpty()) {
            cantidad.setError("complete los campos");
        }
        /*    else if(horas1.isEmpty()){
                horas.setError("complete los campos");
            }*/
        else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://10.0.2.2:8000/api/insertarreactivos", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Datos insertados")) {
                        Toast.makeText(getApplicationContext(), "datos ingresados", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    } else {
                        Toast.makeText(insertarreactivos.this, response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(insertarreactivos.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    ;
                    progressDialog.dismiss();
                    ;
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AbstractMethodError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("nombre", nombre1);
                    params.put("descripcion", descripcion1);
                    params.put("cantidad", cantidad1);

                    //   params.put("horas",horas1);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(insertarreactivos.this);
            requestQueue.add(request);

        }
    }
}


