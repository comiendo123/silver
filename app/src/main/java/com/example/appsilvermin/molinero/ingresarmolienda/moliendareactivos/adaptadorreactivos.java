package com.example.appsilvermin.molinero.ingresarmolienda.moliendareactivos;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appsilvermin.R;
import com.example.appsilvermin.almacenero.reactivo.insertarreactivos.itemreactivo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class adaptadorreactivos extends RecyclerView.Adapter<adaptadorreactivos.MyViewHolder> {
    private List<itemreactivo> mreactivo = new ArrayList<>();
    private Context mContext;
    private List<adaptadorreactivos> mImages = new ArrayList<>();
    private static final String Tag = "adaptadorreactivo";
    String idds;
    RequestQueue requestQueue;
   String idconcentrado;


    public adaptadorreactivos(Context context, List<itemreactivo> mreactivo) {

        this.mreactivo = mreactivo;
        this.mContext = context;
    }


    @NonNull
    @Override
    public adaptadorreactivos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemreactivoolienda, parent, false);
        adaptadorreactivos.MyViewHolder holder = new adaptadorreactivos.MyViewHolder(view);
        return holder;
    }
    public void enviarDatos(String idconcentrado) {

        // Actualizas los valores de las variables
        idconcentrado = idconcentrado;
        System.out.println(idconcentrado+"kkkkk");

    }
    @Override
    public void onBindViewHolder(adaptadorreactivos.MyViewHolder holder, int position) {
        // String cante
        //   holder.cantidadreactivo.setText(mreactivo.get(holder.getAdapterPosition()).getCantidad());

        holder.id.setText(mreactivo.get(holder.getAdapterPosition()).getId());
        holder.nombrereactivo.setText(mreactivo.get(holder.getAdapterPosition()).getNombre());

//ADQUIRIR VALOE ID
        holder.cardver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String idconcentradoss = holder.idconcentrado.getText().toString();
                String idd = holder.id.getText().toString();
                String canti = holder.cantidadreactivo.getText().toString();
                System.out.println(canti+"777777");
                System.out.println(idd+"777777");
                System.out.println(idconcentrado+"6666666555");
                System.out.println(idconcentrado+"7767777");
                ProgressDialog progressDialog = new ProgressDialog(mContext);
                progressDialog.show();
                StringRequest request = new StringRequest(Request.Method.POST, "http://10.0.2.2:8000/api/insertarreactivoconcentrado/", new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("Datos insertados")) {
                            Toast.makeText(mContext, "datos ingresados", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        } else {
                            Toast.makeText(mContext, response, Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }

                }, new com.android.volley.Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_SHORT).show();
                        ;
                        progressDialog.dismiss();
                        ;
                    }
                }) {//AGREGAR VALORES
                    @Override
                    protected Map<String, String> getParams() throws AbstractMethodError {
                        Map<String, String> params = new HashMap<String, String>();
                        //  params.put("id", null);
                        params.put("cantidad", canti);
                        params.put("sector", "molienda");
                        params.put("idreactivos", idd);
                        params.put("idconcentrados", idconcentrado);

                        //  params.put("idmolienda", sectoor);



                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(mContext);

                requestQueue.add(request);
                //   return idconcentrado;


            }
        });


        //Picasso.get().load(constant.urlss + "images/ost/" + mflotacion.get(position).getImagen()).into(holder.imagen);

//ENVIANDO DATOS DE EQUIPO
  /*      holder.cardver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mflotacion.get(holder.getAdapterPosition()));
                Intent intent = new Intent(mContext, admindetalleusuario.class);
                intent = intent.putExtra("id", mflotacion.get(holder.getAdapterPosition()).getId());
                mContext.startActivity(intent);
            }
        });
*/
      /*  holder.modificarcelda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mflotacion.get(holder.getAdapterPosition()));
                Intent intent = new Intent(mContext, modificarcelda.class);
                intent = intent.putExtra("mod", mflotacion.get(holder.getAdapterPosition()).getId());
                mContext.startActivity(intent);     }
        });
*/



  /*      holder.eliminarcelda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idds= holder.id.getText().toString();
                eliminarusuario(idds);
                System.out.println(idds);

            }
            public void eliminarusuario(String idds){

                AlertDialog.Builder builder= new AlertDialog.Builder(mContext);
                builder.setTitle("ELIMINANDO EQUIPO");
                builder.setMessage("Confirmar para eliminar");
                builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton("ELIMINAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        StringRequest request = new StringRequest(Request.Method.DELETE, "http://10.0.2.2:8000/api/eliminarequipo/"+idds, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Toast.makeText(mContext.getApplicationContext(), "eliminado correctamente", Toast.LENGTH_SHORT).show();
                                //mContext.startActivity(new Intent(g(),MainActivity.class));

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(mContext.getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }){
                    /*@Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String,String> params = new HashMap<String,String>();
                        params.put("id", idds);
                        return params;
                    }*/
    /*                    };

                        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
                        requestQueue.add(request);

                    }
                });       AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }


*/}
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return this.mreactivo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        TextView id,idconcentrado,  cantidadreactivo,nombrereactivo;
        // ImageView imagen, modificarcelda, eliminarcelda;
        CardView cardver;
        //  CheckBox checkbox;
     //   ConstraintLayout parentlayout;
        Bundle datos;

        public MyViewHolder(View itemView) {
            super(itemView);
        //    parentlayout = itemView.findViewById(R.id.layoureactivo);
            //  parentlayout=itemView.findViewById(R.id.imagenusuario);
            // context = itemView.getContext();
            id = itemView.findViewById(R.id.idreactivo);
            idconcentrado = itemView.findViewById(R.id.idconcentradoss);
            cardver = itemView.findViewById(R.id.cardverreactivo);
            //     checkbox = itemView.findViewById(R.id.checkBoxreactivo);
            cantidadreactivo = itemView.findViewById(R.id.edittextvercantidad);
            nombrereactivo=itemView.findViewById(R.id.nombrereactivo);
            //   id=itemView.findViewById(R.id.idcelda);
            //    imagen = itemView.findViewById(R.id.imagenusuario);


        }

        public void setOnClockListerner() {

        }

        @Override
        public void onClick(View view) {

        }
    }
}
