package com.example.appsilvermin.administrador.adminverusuarios;

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

public class admindetalleusuario extends AppCompatActivity {
    String url = "http://10.0.2.2:8000/api/usuario";
    private List<itemtrabajador> usuario;
    Context context;
    Button iratras;
    TextView idtra, nombre , apellidos, ci, cargo, celular, passwordd;
    itemtrabajador u ;
    private ApiInterface apiInterface;

    Bundle datos;
    private adaptadortrabajador adapter;
    //String dd="no funciona";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindetalleusuario);
        iratras=(Button)findViewById(R.id.botonmodificarusuario);
        idtra= (TextView) findViewById(R.id.idetalleusuario);
        nombre= (TextView) findViewById(R.id.modnumero);
        apellidos= (TextView) findViewById(R.id.apellidosdetalleusuario);
        ci= (TextView) findViewById(R.id.modmarca);
        cargo= (TextView) findViewById(R.id.cargodetalleusuario);
        celular= (TextView) findViewById(R.id.celulardetalleusuario);

        passwordd= (TextView) findViewById(R.id.contrasenadetalleusuario);
        // passwordd= (TextView) findViewById(R.id.);


        datos = getIntent().getExtras();
        String id = datos.getString("id");
        idtra= (TextView) findViewById(R.id.idetalleusuario);
        idtra.setText(id);
        nombre.setText(id);
       /* datos = getIntent().getExtras();
        String nombres = datos.getString("nombre");
        nombre= (TextView) findViewById(R.id.nombredetalleusuario);
        nombre.setText(nombres);
*/
        apiInterface = retrofet.getApChancado().create(ApiInterface.class);
        Log.d(TAG, "initRecyclerView: init recyclerciew.");

        Call<itemtrabajador> callw = apiInterface.getUsuarioxid(id);
        //  adapter = new ArrayAdapter<adaptadortrabajador>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, usuario);

        iratras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), adminverusuarios.class);
                startActivityForResult(intent, 0);
            }
        });

        callw.enqueue(new Callback<itemtrabajador>() {
            @Override
            public void onResponse(Call<itemtrabajador> call, Response<itemtrabajador> response) {

                //usuario = response.body();
                try {//ARA IMAGEN
                    if(response.isSuccessful()){
                        itemtrabajador  u= (itemtrabajador) response.body();
                        //  itemtrabajador listausuario=response.body();
                        //String urliamgen="http://10.0.2.2:8000/"+p.getimaen+".jpg";
                        nombre.setText(u.getNombres());
                        apellidos.setText(u.getApellidos());
                        ci.setText(u.getCiusuario());
                        cargo.setText(u.getCargo());
                        celular.setText(u.getCelular());
                        passwordd.setText(u.getPasswordd());
                        //   Glide.with(getApplication()).load(urlimagen).into(imagen);

                    }

                }catch (Exception ex){
                    Toast.makeText(admindetalleusuario.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    //  nombre.setText(dd);
                }

            }

            @Override
            public void onFailure(Call<itemtrabajador> call, Throwable t) {

            }


        });










    /* Retrofit retrofit= new Retrofit.Builder().baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    apiservice apiservice = retrofit.create(apiservice.class);
    Call<itemtrabajador> call=apiservice.getUsuarioxid(id);
    call.enqueue(new Callback<itemtrabajador>() {
        @Override
        public void onResponse(Call<itemtrabajador> call, Response<itemtrabajador> response) {
            try {//ARA IMAGEN
                if(response.isSuccessful()){
                  itemtrabajador  u= (itemtrabajador) response.body();
                  //  itemtrabajador listausuario=response.body();
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
                Toast.makeText(admindetalleusuario.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<itemtrabajador> call, Throwable t) {
            Toast.makeText(getApplicationContext(),
                    "Toast por defecto", Toast.LENGTH_SHORT);
        }
    });*/

    }

/*   Bundle bundle = getIntent().getExtras();
        tvSaludo.setText("Nombre: "+bundle.getString("nombre")+"\nDNI: "+bundle.getString("dni")+"\nSexo: "+bundle.getString("sexo"));
    }
    public void onBindViewHolder(@NonNull adaptadortrabajador.MyViewHolder holder, int position) {
        //    holder.imagen.setImageURI(usuario.get(position).getImagen());
        holder.nombres.setText(usuario.get(position).getNombre());
        holder.aellidos.setText(usuario.get(position).getApellidos());
        // Picasso.get().load(constant.urlss+"images/ost/"+usuario.get(position).getImagen()).into(holder.imagen);
        Glide.with(holder.imagen)
                .load(new File(usuario.get(position).getImagen()))
                .placeholder(R.drawable.invitado)
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imagen);  /* Glide.with(holder.imagen)
                .load(new File(url+'images/ost/'+usuario)//usuario.get(position).getImagen()))
                .placeholder(R.drawable.invitado)
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imagen);*/
  /*      holder.setOnClockListerner();
    }
*/

}