package com.example.appsilvermin.administrador.adminverceldas.flotacion;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsilvermin.R;
import com.example.appsilvermin.apiservice.ApiInterface;
import com.example.appsilvermin.apiservice.retrofet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class admindetallecelda extends AppCompatActivity {

    String url = "http://10.0.2.2:8000/api/celda";
    private List<itemcelda> celda;
    Context context;
    Button iratras;
    TextView id, nombre , descripcion, cantidadhoras, seccion;

    private ApiInterface apiInterface;

    Bundle datos;

    //String dd="no funciona";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindetallecelda);

        iratras=(Button)findViewById(R.id.botonmodificarcelda);
        id= (TextView) findViewById(R.id.idetallecelda);
        nombre= (TextView) findViewById(R.id.nombredetallecelda);
        descripcion= (TextView) findViewById(R.id.descripciondetallecelda);
        cantidadhoras= (TextView) findViewById(R.id.cantidadhorasdetallechancadira);
        seccion= (TextView) findViewById(R.id.secciondetallecelda);
        // passwordd= (TextView) findViewById(R.id.);


        datos = getIntent().getExtras();
        String idtra= datos.getString("id");
        id= (TextView) findViewById(R.id.idetallecelda);
        id.setText(idtra);
        // nombre.setText(idtra);
       /* datos = getIntent().getExtras();
        String nombres = datos.getString("nombre");
        nombre= (TextView) findViewById(R.id.nombredetallecelda);
        nombre.setText(nombres);
*/
        apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<itemcelda> callw = apiInterface.getCeldaxid(idtra);
        //  adapter = new ArrayAdapter<adaptadortrabajador>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, celda);

        iratras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), celda.class);
                startActivityForResult(intent, 0);
            }
        });

        callw.enqueue(new Callback<itemcelda>() {
            @Override
            public void onResponse(Call<itemcelda> call, Response<itemcelda> response) {

                //celda = response.body();
                try {//ARA IMAGEN
                    if(response.isSuccessful()){
                        itemcelda  u= (itemcelda) response.body();
                        //  itemcelda listacelda=response.body();
                        //String urliamgen="http://10.0.2.2:8000/"+p.getimaen+".jpg";
                        nombre.setText(u.getNombre());
                        id.setText(u.getId());
                        descripcion.setText(u.getDescripcion());
                        cantidadhoras.setText(u.getCantidadhoras());
                        seccion.setText(u.getSeccion());
                        //   Glide.with(getApplication()).load(urlimagen).into(imagen);

                    }

                }catch (Exception ex){
                    Toast.makeText(admindetallecelda.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    //  nombre.setText(dd);
                }

            }

            @Override
            public void onFailure(Call<itemcelda> call, Throwable t) {
                System.out.println("furea de serviico");
            }


        });










    /* Retrofit retrofit= new Retrofit.Builder().baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    apiservice apiservice = retrofit.create(apiservice.class);
    Call<itemcelda> call=apiservice.getceldaxid(id);
    call.enqueue(new Callback<itemcelda>() {
        @Override
        public void onResponse(Call<itemcelda> call, Response<itemcelda> response) {
            try {//ARA IMAGEN
                if(response.isSuccessful()){
                  itemcelda  u= (itemcelda) response.body();
                  //  itemcelda listacelda=response.body();
                    //String urliamgen="http://10.0.2.2:8000/"+p.getimaen+".jpg";
                    nombre.setText(u.getNombres());
                //    apellidos.setText(u.getNombre());
               //     ci.setText(u.get());
                    cargo.setText(u.getCargo());
                    celular.setText(u.getCelular());
                    passwordd.setText(u.getPasswordd());
                 //   Glide.with(getApplication()).load(urlimagen).into(imagen);

                }
            }catch (Exception ex){
                Toast.makeText(admindetallecelda.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<itemcelda> call, Throwable t) {
            Toast.makeText(getApplicationContext(),
                    "Toast por defecto", Toast.LENGTH_SHORT);
        }
    });*/

    }

/*   Bundle bundle = getIntent().getExtras();
        tvSaludo.setText("Nombre: "+bundle.getString("nombre")+"\nDNI: "+bundle.getString("dni")+"\nSexo: "+bundle.getString("sexo"));
    }
    public void onBindViewHolder(@NonNull adaptadortrabajador.MyViewHolder holder, int position) {
        //    holder.imagen.setImageURI(celda.get(position).getImagen());
        holder.nombres.setText(celda.get(position).getNombre());
        holder.aellidos.setText(celda.get(position).getApellidos());
        // Picasso.get().load(constant.urlss+"images/ost/"+celda.get(position).getImagen()).into(holder.imagen);
        Glide.with(holder.imagen)
                .load(new File(celda.get(position).getImagen()))
                .placeholder(R.drawable.invitado)
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imagen);  /* Glide.with(holder.imagen)
                .load(new File(url+'images/ost/'+celda)//celda.get(position).getImagen()))
                .placeholder(R.drawable.invitado)
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imagen);*/
  /*      holder.setOnClockListerner();
    }
*/

}