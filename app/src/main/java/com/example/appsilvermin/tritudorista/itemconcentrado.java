package com.example.appsilvermin.tritudorista;

public class itemconcentrado {

    String id,fechaconcentrado,tiempo,ley;


    public itemconcentrado(String id, String fechaconcentrado, String tiempo, String ley) {
        this.id = id;
        this.fechaconcentrado = fechaconcentrado;
        this.tiempo = tiempo;
        this.ley = ley;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaconcentrado() {
        return fechaconcentrado;
    }

    public void setFechaconcentrado(String fechaconcentrado) {
        this.fechaconcentrado = fechaconcentrado;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getLey() {
        return ley;
    }

    public void setLey(String ley) {
        this.ley = ley;
    }
}
