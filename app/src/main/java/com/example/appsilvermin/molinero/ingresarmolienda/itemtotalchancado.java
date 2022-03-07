package com.example.appsilvermin.molinero.ingresarmolienda;

public class itemtotalchancado {
    String idchancadotrabajo;
    String cantidadentrada;
    String hora;
    String fechaconcentrado;
    String nombre;
    String descripcion;
    String tiempo;
    String tms;
    String ley;
    String idchancado;
    String idconcentrado;
    public itemtotalchancado(String idconcentrado,String idchancado,String idchancadotrabajo, String cantidadentrada, String hora, String fechaconcentrado, String nombre, String descripcion, String tiempo, String tms, String ley) {
        this.idchancadotrabajo = idchancadotrabajo;
        this.cantidadentrada = cantidadentrada;
        this.hora = hora;
        this.fechaconcentrado = fechaconcentrado;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
        this.tms = tms;
        this.ley = ley;
        this.idchancado=idchancado;
        this.idconcentrado=idconcentrado;
    }

    public String getIdconcentrado() {
        return idconcentrado;
    }

    public void setIdconcentrado(String idconcentrado) {
        this.idconcentrado = idconcentrado;
    }

    public String getIdchancado() {
        return idchancado;
    }

    public void setIdchancado(String idchancado) {
        this.idchancado = idchancado;
    }

    public String getidchancadotrabajo() {
        return idchancadotrabajo;
    }

    public void setidchancadotrabajo(String idchancadotrabajo) {
        this.idchancadotrabajo = idchancadotrabajo;
    }

    public String getCantidadentrada() {
        return cantidadentrada;
    }

    public void setCantidadentrada(String cantidadentrada) {
        this.cantidadentrada = cantidadentrada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFechaconcentrado() {
        return fechaconcentrado;
    }

    public void setFechaconcentrado(String fechaconcentrado) {
        this.fechaconcentrado = fechaconcentrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTms() {
        return tms;
    }

    public void setTms(String tms) {
        this.tms = tms;
    }

    public String getLey() {
        return ley;
    }

    public void setLey(String ley) {
        this.ley = ley;
    }
}

