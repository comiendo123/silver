package com.example.appsilvermin.almacenero.reactivo.insertarreactivos;

import static android.content.ContentValues.TAG;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appsilvermin.R;
import com.example.appsilvermin.administrador.adminverceldas.chancadora.admindetallechancadora;

import com.example.appsilvermin.administrador.adminverceldas.chancadora.modificarchancadora;

import java.util.ArrayList;
import java.util.List;

public class adaptadorreactivo extends RecyclerView.Adapter<adaptadorreactivo.MyViewHolder> {

    
        private List<itemreactivo> mreactivo = new ArrayList<>();
    private Context mContext;
    private static final String Tag = "adaptadorreactivo";
    String idds;
  




    public adaptadorreactivo(Context context, List<itemreactivo> reactivo) {

        this.mreactivo = reactivo;
        this.mContext = context;
    }


    @NonNull
    @Override
    public adaptadorreactivo.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemreactivo, parent, false);
        adaptadorreactivo.MyViewHolder holder = new adaptadorreactivo.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(adaptadorreactivo.MyViewHolder holder, int position) {

        holder.nombres.setText(mreactivo.get(holder.getAdapterPosition()).getNombre());
        holder.cantidad.setText(mreactivo.get(holder.getAdapterPosition()).getDescripcion());
        holder.ids.setText(mreactivo.get(holder.getAdapterPosition()).getId());
//ADQUIRIR VALOE ID



        //  Picasso.get().load(constant.urlss + "images/ost/" + mreactivo.get(position).getImagen()).into(holder.imagen);


        holder.cardver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mreactivo.get(holder.getAdapterPosition()));
                Intent intent = new Intent(mContext, admindetallechancadora.class);
                intent = intent.putExtra("id", mreactivo.get(holder.getAdapterPosition()).getId());
                mContext.startActivity(intent);
            }
        });

        holder.modificarreactivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mreactivo.get(holder.getAdapterPosition()));
                Intent intent = new Intent(mContext, modificarchancadora.class);
                intent = intent.putExtra("mod", mreactivo.get(holder.getAdapterPosition()).getId());
                mContext.startActivity(intent);     }
        });




        holder.eliminarreactivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idds= holder.ids.getText().toString();
                eliminarusuario(idds);
                System.out.println(idds);

            }
            public void eliminarusuario(String idds){

                AlertDialog.Builder builder= new AlertDialog.Builder(mContext);
                builder.setTitle("ELIMINANDO REACTIVO");
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


                        StringRequest request = new StringRequest(Request.Method.DELETE, "http://10.0.2.2:8000/api/eliminarreactivos/"+idds, new Response.Listener<String>() {
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
                        };

                        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
                        requestQueue.add(request);

                    }
                });       AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }



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
        TextView nombres, cantidad, ids;
        ImageView imagen, modificarreactivo, eliminarreactivo;
        CardView cardver;


        public MyViewHolder(View itemView) {
            super(itemView);
             context = itemView.getContext();
            ids = itemView.findViewById(R.id.idreacivo);
            cardver = itemView.findViewById(R.id.cardver);
            nombres = itemView.findViewById(R.id.nomreactivo);
            cantidad = itemView.findViewById(R.id.cantidadreactivo);

            imagen = itemView.findViewById(R.id.imagenchancdora);

            modificarreactivo = itemView.findViewById(R.id.modificarreactivo);
            eliminarreactivo = itemView.findViewById(R.id.eliminarreactivo);

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

