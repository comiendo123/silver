package com.example.appsilvermin.superusuario.verdatos;

public class modelproceso {

    String id,anio,mes,dia,cantidadentrada,hora,ley;

    public modelproceso(String id, String anio, String mes, String dia, String cantidadentrada, String hora, String ley) {
        this.id = id;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.cantidadentrada = cantidadentrada;
        this.hora = hora;
        this.ley = ley;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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

    public String getLey() {
        return ley;
    }

    public void setLey(String ley) {
        this.ley = ley;
    }
}
