package com.example.appsilvermin.administrador.adminverceldas.chancadora;

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

public class admindetallechancadora extends AppCompatActivity {

    String url = "http://10.0.2.2:8000/api/chancadora";
    private List<itemchancadora> chancadora;
    Context context;
    Button iratras;
    TextView id, nombre , descripcion, cantidadhoras, seccion;

    private ApiInterface apiInterface;

    Bundle datos;

    //String dd="no funciona";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindetallechancadora);

        iratras=(Button)findViewById(R.id.botonmodificarchancadora);
        id= (TextView) findViewById(R.id.idetallechancadora);
        nombre= (TextView) findViewById(R.id.nombredetallechancadora);
        descripcion= (TextView) findViewById(R.id.descripciondetallechancadora);
        cantidadhoras= (TextView) findViewById(R.id.cantidadhorasdetallechancadira);
        seccion= (TextView) findViewById(R.id.secciondetallechancadora);
          // passwordd= (TextView) findViewById(R.id.);


        datos = getIntent().getExtras();
        String idtra= datos.getString("id");
        id= (TextView) findViewById(R.id.idetallechancadora);
        id.setText(idtra);
       // nombre.setText(idtra);
       /* datos = getIntent().getExtras();
        String nombres = datos.getString("nombre");
        nombre= (TextView) findViewById(R.id.nombredetallechancadora);
        nombre.setText(nombres);
*/
        apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<itemchancadora> callw = apiInterface.getChancadoraxid(idtra);
        //  adapter = new ArrayAdapter<adaptadortrabajador>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, chancadora);

        iratras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), chancadora.class);
                startActivityForResult(intent, 0);
            }
        });

        callw.enqueue(new Callback<itemchancadora>() {
            @Override
            public void onResponse(Call<itemchancadora> call, Response<itemchancadora> response) {

                //chancadora = response.body();
                try {//ARA IMAGEN
                    if(response.isSuccessful()){
                        itemchancadora  u= (itemchancadora) response.body();
                        //  itemchancadora listachancadora=response.body();
                        //String urliamgen="http://10.0.2.2:8000/"+p.getimaen+".jpg";
                        nombre.setText(u.getNombre());
                        id.setText(u.getId());
                        descripcion.setText(u.getDescripcion());
                        cantidadhoras.setText(u.getCantidadhoras());
                        seccion.setText(u.getSeccion());
                         //   Glide.with(getApplication()).load(urlimagen).into(imagen);

                    }

                }catch (Exception ex){
                    Toast.makeText(admindetallechancadora.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    //  nombre.setText(dd);
                }

            }

            @Override
            public void onFailure(Call<itemchancadora> call, Throwable t) {
           System.out.println("furea de serviico");
            }


        });










    /* Retrofit retrofit= new Retrofit.Builder().baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    apiservice apiservice = retrofit.create(apiservice.class);
    Call<itemchancadora> call=apiservice.getchancadoraxid(id);
    call.enqueue(new Callback<itemchancadora>() {
        @Override
        public void onResponse(Call<itemchancadora> call, Response<itemchancadora> response) {
            try {//ARA IMAGEN
                if(response.isSuccessful()){
                  itemchancadora  u= (itemchancadora) response.body();
                  //  itemchancadora listachancadora=response.body();
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
                Toast.makeText(admindetallechancadora.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<itemchancadora> call, Throwable t) {
            Toast.makeText(getApplicationContext(),
                    "Toast por defecto", Toast.LENGTH_SHORT);
        }
    });*/

    }

/*   Bundle bundle = getIntent().getExtras();
        tvSaludo.setText("Nombre: "+bundle.getString("nombre")+"\nDNI: "+bundle.getString("dni")+"\nSexo: "+bundle.getString("sexo"));
    }
    public void onBindViewHolder(@NonNull adaptadortrabajador.MyViewHolder holder, int position) {
        //    holder.imagen.setImageURI(chancadora.get(position).getImagen());
        holder.nombres.setText(chancadora.get(position).getNombre());
        holder.aellidos.setText(chancadora.get(position).getApellidos());
        // Picasso.get().load(constant.urlss+"images/ost/"+chancadora.get(position).getImagen()).into(holder.imagen);
        Glide.with(holder.imagen)
                .load(new File(chancadora.get(position).getImagen()))
                .placeholder(R.drawable.invitado)
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imagen);  /* Glide.with(holder.imagen)
                .load(new File(url+'images/ost/'+chancadora)//chancadora.get(position).getImagen()))
                .placeholder(R.drawable.invitado)
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imagen);*/
  /*      holder.setOnClockListerner();
    }
*/

}