package com.example.appsilvermin.administrador.adminverceldas.chancadora;

public class itemchancadora {
    String id, nombre,descripcion,cantidadhoras,salidatotal,seccion;

    public itemchancadora(String id, String nombre, String descripcion, String cantidadhoras, String salidatotal, String seccion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadhoras = cantidadhoras;
        this.salidatotal = salidatotal;
        this.seccion = seccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCantidadhoras() {
        return cantidadhoras;
    }

    public void setCantidadhoras(String cantidadhoras) {
        this.cantidadhoras = cantidadhoras;
    }

    public String getSalidatotal() {
        return salidatotal;
    }

    public void setSalidatotal(String salidatotal) {
        this.salidatotal = salidatotal;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
}