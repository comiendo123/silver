package com.example.appsilvermin.molinero.ingresarmolienda.moliendareactivos;

public class itemreactivoconcentrado {
    String id,fechaconcentrado,nombre,cantidad,idconcentrado,sector;

    public itemreactivoconcentrado(String id, String fechaconcentrado, String nombre, String cantidad, String idconcentrado,String sector) {
        this.id = id;
        this.fechaconcentrado = fechaconcentrado;
        this.nombre = nombre;
        this.cantidad=cantidad;
        this.idconcentrado = idconcentrado;
        this.sector = sector;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdconcentrado() {
        return idconcentrado;
    }

    public void setIdconcentrado(String idconcentrado) {
        this.idconcentrado = idconcentrado;
    }

    public void setIdconcentrados(String idconcentrado) {
        this.idconcentrado = idconcentrado;
    }
}


