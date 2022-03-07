package com.example.appsilvermin.reactiveros;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.example.appsilvermin.R;
import com.example.appsilvermin.molinero.ingresarmolienda.insertarmoliendas;

import java.util.ArrayList;
import java.util.List;

public class adatadormoliendatotal extends RecyclerView.Adapter<adatadormoliendatotal.MyViewHolder> {
    private List<itemmoliendatotal> musuario = new ArrayList<>();
    private Context mContext;
    private List<itemmoliendatotal> mImages = new ArrayList<>();
    private static final String Tag = "adatadormoliendatotal";
    String idds;
    RequestQueue requestQueue;




    public adatadormoliendatotal(Context context, List<itemmoliendatotal> usuario) {

        this.musuario = usuario;
        this.mContext = context;
    }


    @NonNull
    @Override
    public adatadormoliendatotal.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemmoliendatotal, parent, false);
        adatadormoliendatotal.MyViewHolder holder = new adatadormoliendatotal.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(adatadormoliendatotal.MyViewHolder holder, int position) {

        holder.fecha.setText("FECHA :"+musuario.get(holder.getAdapterPosition()).getFechaconcentrado());
        holder.ley.setText("LEY :"+musuario.get(holder.getAdapterPosition()).getNombre());
        holder.ids.setText(musuario.get(holder.getAdapterPosition()).getIdmoliendatrabajo());
//ADQUIRIR VALOE ID



        //  Picasso.get().load(constant.urlss + "images/ost/" + musuario.get(position).getImagen()).into(holder.imagen);


        holder.cardver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + musuario.get(holder.getAdapterPosition()));
                Intent intent = new Intent(mContext, insertarmoliendas.class);
                intent = intent.putExtra("id", musuario.get(holder.getAdapterPosition()).getIdmoliendatrabajo());
                mContext.startActivity(intent);
            }
        });


/*
      holder.eliminarusuario.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            idds= holder.ids.getText().toString();
            eliminarusuario(idds);
            System.out.println(idds);

         }
    /*     public void eliminarusuario(String idds){

            AlertDialog.Builder builder= new AlertDialog.Builder(mContext);
            builder.setTitle("ELIMINANDO USUARIO");
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


                  StringRequest request = new StringRequest(Request.Method.DELETE, "http://10.0.2.2:8000/api/eliminarusuario/"+idds, new Response.Listener<String>() {
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
          /*        };

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
        return this.musuario.size();
    }
    /*
        public void enviarDatos(String fechaconcentrado) {
            fechaconcentrado=fechaconcentrado;
            System.out.println(fechaconcentrado+"ooooohhhhh");
        }
    */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        TextView fecha, ley, ids;
        ImageView imagen, modificarusuario, eliminarusuario;
        CardView cardver;
        ConstraintLayout parentlayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            ids = itemView.findViewById(R.id.idconcentradohistoril);
            cardver = itemView.findViewById(R.id.cardver);
            fecha = itemView.findViewById(R.id.fechamolienda);
            ley = itemView.findViewById(R.id.leymolienda);


        }

        public void setOnClockListerner() {

        }

        @Override
        public void onClick(View view) {

        }
/*
    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.modificarusuario:
                Intent intenta = new Intent(view.getContext(), modificarperfil.class);
                context.startActivity(intenta);
                break;
            //CAMBIAR ACTIVITY
            case R.id.eliminarusuario:
                Intent intento = new Intent(view.getContext(), administradoragregartrabajador.class);
                context.startActivity(intento);
                break;
        }
  */  }
}






           /*String url = "http://10.0.2.2:8000/api/eliminarUsuario/";

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                builder.setTitle("ELIMINANDO USUARIO");
                builder.setMessage("Quieres confirmar?");
                builder.setNegativeButton("Cancelat", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    StringRequest stringRequest=new StringRequest(Request.Method.DELETE, url+holder.ids,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                    JSONObject object=new JSONObject(response);
                                    String check=object.getString("state");
                                    if(check.equals("delete")){
                                        holder.eliminarusuario(holder.getAdapterPosition());
                                        Toast.makeText(mContext, "Se elimono el registro",
                                                Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(mContext, response,
                                                Toast.LENGTH_SHORT).show();

                                    }
                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext,error.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }){
                        @Override
                        protected Map<String, String>getParams()throws AuthFailureError{
                            HashMap<String.String> deleteParams=new HashMap<>();
                            deleteParams.put("ciusuario",holder.nombres.getNombres());
                            return deleteParams;
                        }
                    };
                    RequestQueue requestQueue =Volley.newRequestQueue(mContext);
                    requestQueue.add(stringRequest);
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
*/
