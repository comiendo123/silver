package com.example.appsilvermin.administrador.adminverceldas.molino;

public class itemmolino {
    String id,nombre,descripcion,cantidadhoras,seccion;

    public itemmolino(String id, String nombre, String descripcion, String cantidadhoras, String seccion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadhoras = cantidadhoras;
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

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
}
