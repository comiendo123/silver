package com.example.appsilvermin.administrador.adminverceldas.molino;

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
import com.example.appsilvermin.administrador.adminverceldas.molino.adaptadormolino;
import com.example.appsilvermin.administrador.adminverceldas.molino.admindetallemolino;
import com.example.appsilvermin.administrador.adminverceldas.molino.itemmolino;
import com.example.appsilvermin.administrador.adminverceldas.molino.modificarmolino;

import java.util.ArrayList;
import java.util.List;

public class adaptadormolino extends RecyclerView.Adapter<adaptadormolino.MyViewHolder> {

    private List<itemmolino> mmolino = new ArrayList<>();
    private Context mContext;
    private List<itemmolino> mImages = new ArrayList<>();
    private static final String Tag = "adaptadormolino";
    String idds;
    RequestQueue requestQueue;




    public adaptadormolino(Context context, List<itemmolino> molino) {

        this.mmolino = molino;
        this.mContext = context;
    }


    @NonNull
    @Override
    public adaptadormolino.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemmolino, parent, false);
        adaptadormolino.MyViewHolder holder = new adaptadormolino.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(adaptadormolino.MyViewHolder holder, int position) {
        holder.nombres.setText(mmolino.get(holder.getAdapterPosition()).getNombre());
        holder.descripcion.setText(mmolino.get(holder.getAdapterPosition()).getDescripcion());
        holder.ids.setText(mmolino.get(holder.getAdapterPosition()).getId());
//ADQUIRIR VALOE ID



        //  Picasso.get().load(constant.urlss + "images/ost/" + mmolino.get(position).getImagen()).into(holder.imagen);


        holder.cardver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mmolino.get(holder.getAdapterPosition()));
                Intent intent = new Intent(mContext, admindetallemolino.class);
                intent = intent.putExtra("id", mmolino.get(holder.getAdapterPosition()).getId());
                mContext.startActivity(intent);
            }
        });

        holder.modificarmolino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mmolino.get(holder.getAdapterPosition()));
                Intent intent = new Intent(mContext, modificarmolino.class);
                intent = intent.putExtra("mod", mmolino.get(holder.getAdapterPosition()).getId());
                mContext.startActivity(intent);     }
        });




        holder.eliminarmolino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idds= holder.ids.getText().toString();
                eliminarmolino(idds);
                System.out.println(idds);

            }
            public void eliminarmolino(String idds){

                AlertDialog.Builder builder= new AlertDialog.Builder(mContext);
                builder.setTitle("ELIMINANDO MOLINO");
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


                        StringRequest request = new StringRequest(Request.Method.DELETE, "http://10.0.2.2:8000/api/eliminarmolienda/"+idds, new Response.Listener<String>() {
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
        return this.mmolino.size();
    }
    /*
        public void enviarDatos(String fechaconcentrado) {
            fechaconcentrado=fechaconcentrado;
            System.out.println(fechaconcentrado+"ooooohhhhh");
        }
    */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        TextView nombres, descripcion, ids;
        ImageView imagen, modificarmolino, eliminarmolino;
        CardView cardver;
        ConstraintLayout parentlayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            //       parentlayout = itemView.findViewById(R.id.chancadolayout);
            //  parentlayout=itemView.findViewById(R.id.imagenmolino);
            context = itemView.getContext();
            ids = itemView.findViewById(R.id.idmolino);
            cardver = itemView.findViewById(R.id.cardver);
            nombres = itemView.findViewById(R.id.nombeemolino);
            descripcion = itemView.findViewById(R.id.descripcionmolino);

            imagen = itemView.findViewById(R.id.imagenmolino);

            modificarmolino = itemView.findViewById(R.id.modificarmolino);
            eliminarmolino = itemView.findViewById(R.id.eliminarmolino);

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

            case R.id.modificarmolino:
                Intent intenta = new Intent(view.getContext(), modificarperfil.class);
                context.startActivity(intenta);
                break;
            //CAMBIAR ACTIVITY
            case R.id.eliminarmolino:
                Intent intento = new Intent(view.getContext(), administradoragregartrabajador.class);
                context.startActivity(intento);
                break;
        }
  */  }
}






           /*String url = "http://10.0.2.2:8000/api/eliminarmolino/";

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                builder.setTitle("ELIMINANDO molino");
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
                                        holder.eliminarmolino(holder.getAdapterPosition());
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
                            deleteParams.put("cimolino",holder.nombres.getNombres());
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


