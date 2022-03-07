package com.example.appsilvermin.reactiveros;

public class itemmoliendatotal {
    String idmoliendatrabajo,cantidadentrada,hora,fechaconcentrado,nombre,idconcentrado,idmolienda;

    public itemmoliendatotal(String idmoliendatrabajo, String cantidadentrada, String hora, String fechaconcentrado, String nombre, String idconcentrado, String idmolienda) {
        this.idmoliendatrabajo = idmoliendatrabajo;
        this.cantidadentrada = cantidadentrada;
        this.hora = hora;
        this.fechaconcentrado = fechaconcentrado;
        this.nombre = nombre;
        this.idconcentrado = idconcentrado;
        this.idmolienda = idmolienda;
    }

    public String getIdmoliendatrabajo() {
        return idmoliendatrabajo;
    }

    public void setIdmoliendatrabajo(String idmoliendatrabajo) {
        this.idmoliendatrabajo = idmoliendatrabajo;
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

    public String getIdconcentrado() {
        return idconcentrado;
    }

    public void setIdconcentrado(String idconcentrado) {
        this.idconcentrado = idconcentrado;
    }

    public String getIdmolienda() {
        return idmolienda;
    }

    public void setIdmolienda(String idmolienda) {
        this.idmolienda = idmolienda;
    }
}
