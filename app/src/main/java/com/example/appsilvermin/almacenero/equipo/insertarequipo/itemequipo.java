package com.example.appsilvermin.almacenero.equipo.insertarequipo;

public class itemequipo {
    String id,nombre,talla,marca,cantidad;

    public itemequipo(String id, String nombre, String talla, String marca, String cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.talla = talla;
        this.marca = marca;
        this.cantidad = cantidad;
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

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
