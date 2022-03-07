package com.example.appsilvermin.apiservice;

import com.example.appsilvermin.administrador.adminverceldas.chancadora.itemchancadora;
import com.example.appsilvermin.administrador.adminverceldas.flotacion.itemcelda;
import com.example.appsilvermin.administrador.adminverceldas.molino.itemmolino;
import com.example.appsilvermin.administrador.adminverusuarios.itemtrabajador;
import com.example.appsilvermin.almacenero.equipo.insertarequipo.itemequipo;
import com.example.appsilvermin.almacenero.reactivo.insertarreactivos.itemreactivo;
import com.example.appsilvermin.molinero.ingresarmolienda.itemtotalchancado;
import com.example.appsilvermin.molinero.ingresarmolienda.moliendareactivos.itemreactivoconcentrado;
import com.example.appsilvermin.molinero.itemchancadototal;
import com.example.appsilvermin.reactiveros.itemmoliendatotal;
import com.example.appsilvermin.superusuario.verdatos.modelproceso;
import com.example.appsilvermin.tritudorista.itemconcentrado;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    /*
        //GET EQUIPOR ID
        @GET("equipo/{id}")
        Call<itemequipo> getEquipoxida(@Path("id") String id);



        //REACTIVO
        @GET("verreactivototal")
        Call<List<itemitemtotalreactivo>> getReactivos();

        //FECHA PARA CONCENTRADO
        @GET("datosfecha")
        Call<List<itemfechareporte>> getFechas();

        @GET("verconcentradototal/{fechaconcentrado}")
        Call<List<itemconcentrado>>getConce(@Path("fechaconcentrado") String fechaconcentrado);

        @GET("equipo")
        Call<List<itemequipo>> getEquipo();


        @GET("verconcentradototal/{fechaconcentrado}")
        Call<List<itemparapdf>>getConcefecha(@Path("fechaconcentrado") String fechaconcentrado);

        @GET("verconcentradototales")
        Call<List<itemconcentrado>>getConc();


        //FLOTACION
        @GET("verflotaciontotal")
        Call<List<itemflotaciontotal>> getFlotacionconcentrado();
    //PARA SPINNER EN MOLIENDA    http://127.0.0.1:8000/api/vermolienda/{nombre}
        //PARA SPIINER CHANCADO   http://127.0.0.1:8000/api/verchancado/{nombre}
        //PARA SPINNER REACTIVOS http://127.0.0.1:8000/api/verreactivos/cal

        //MOLIENDATRABAJO
        @GET("vermoliendatotal")
        Call<List<itemtotalmolienda>> getMoliendatrabajo();

        //MOLIENDA
        @GET("molienda/{id}")
        Call<itemmolienda> getMoliendaxid(@Path("id") String id);

        @GET("vermoliendaxseccion/{id}")
        Call<itemmolienda> getMoliendaxseccion(@Path("id") String id);


    //CHANCADO

        // http://127.0.0.1:8000/api/flotacionconcentrado
        @GET("chancado")
        Call<List<itemchancado>> getChancado();

        @GET("chancado/{id}")
        Call<itemchancado> getChancadoxid(@Path("id") String id);

        @GET("chancadotrabajo")
        Call<List<itemchancado>> getChancadotrabajo();

        @GET("verchancadototal")
        Call<List<itemtotalchancado>> getChancadototal();


        @GET("verchancadototales/{idchancadotrabajo}")
        Call<itemtotalchancado> getChancadototales(@Path("idchancadotrabajo")String id);


        @GET("ultimoconcentrado")
        Call<List<itemchancado>> getConcentrados();


        //EQUIO
        @GET("informes")
        Call<List<listaelementinforme>> getInforme();

        @GET("informes/{id}")
        Call<listaelementinforme> getInformexid(@Path("id") String id);

        @PUT("modificarinformes/{id}")
        Call<listaelementinforme> putInforme(@Path("id") String id); //ody itemtrabajador usuario);

        //   INFORMES
        @GET("equipo")
        Call<List<itemcelda>> getCelda();

        @GET("equipo/{id}")
        Call<itemequipo> getEquipoxid(@Path("id") String id);

        @PUT("modificarequipo/{id}")
        Call<itemequipo> putEquipo(@Path("id") String id); //ody itemtrabajador usuario);

*/
    //EQUIPO

    @GET("verdesc")
    Call<List<modelproceso>> getProcesoDesc();
    @GET("equipo")
    Call<List<itemequipo>> getEquipo();
    //PROCESO
    @GET("proceso")
    Call<List<modelproceso>> getProceso();

    //REACTIVO

    @GET("reactivos")
    Call<List<itemreactivo>> getReactivo();


    @GET("verreactivototal")
    Call<List<itemreactivoconcentrado>> getReactivototal();

    //molienda
    @GET("vermoliendatotal")
    Call<List<itemmoliendatotal>> getMoliendatotal();

    //CHANCADO
    @GET("verchancado/{seleccion}")
    Call<itemchancadora> getChancadoxseccion(@Path("seleccion")String seleccion);

    @GET("verchancadototal")
    Call<List<itemchancadototal>> getChancadototal();

    @GET("verchancadototales/{idchancadotrabajo}")
    Call<itemtotalchancado> getChancadototales(@Path("idchancadotrabajo")String id);
    //CONCENTRADO
        @GET("ultimoconcentrado")
        Call<itemconcentrado> getultimoConcentrado();





    //CELDA
    @GET("flotacion")
    Call<List<itemcelda>> getCelda();

    @GET("flotacion/{id}")
    Call<itemcelda> getCeldaxid(@Path("id") String id);

    @PUT("modificarflotacion/{id}")
    Call<itemcelda> putCelda(@Path("id") String id); //ody itemtrabajador usuario);




    //MOLINO
    @GET("molienda")
    Call<List<itemmolino>> getMolino();

    @GET("molienda/{id}")
    Call<itemmolino> getMolinoxid(@Path("id") String id);

    @PUT("modificarchancado/{id}")
    Call<itemmolino> putMolino(@Path("id") String id); //ody itemtrabajador usuario);





    //CHANCADO
@GET("chancado")
Call<List<itemchancadora>> getChancado();

    @GET("chancado/{id}")
    Call<itemchancadora> getChancadoraxid(@Path("id") String id);

    @PUT("modificarchancado/{id}")
    Call<itemchancadora> putChancado(@Path("id") String id); //ody itemtrabajador usuario);





    //USUARIO
    @GET("usuario")
    Call<List<itemtrabajador>> getUsuario();


    @GET("verusuarioporci/{ci}")
    Call<itemtrabajador>getUsuarioxci(@Path("ci") String ci);


    //USIO OR ID NO OLVIDAR
    @GET("usuario/{id}")
    Call<itemtrabajador> getUsuarioxid(@Path("id") String id);

    @POST("insertarusuario")
    Call<Void> postUsuario(@Body itemtrabajador usuario);


    @PUT("modificarusuario/{id}")
    Call<itemtrabajador> putUsuario(@Path("id") String id); //ody itemtrabajador usuario);


    @DELETE("eliminarusuario")
    Call<Void> deltUsuario(@Query("id") String idUsuario);


    @POST("celda")
    @FormUrlEncoded
    Call<itemcelda> saveCelda(
            @Field("marca") String marca,
            @Field("numero") String numero,
            @Field("cantidadhoras") String cantidadhoras
    );

}
/*
*/