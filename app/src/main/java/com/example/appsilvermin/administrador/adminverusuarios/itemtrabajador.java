package com.example.appsilvermin.administrador.adminverusuarios;

public class itemtrabajador {

    String id,ciusuario,nombres,apellidos,cargo,celular,passwordd,imagen;

    public itemtrabajador(String id, String ciusuario, String nombres, String apellidos, String cargo,String celular, String passwordd, String imagen) {
        this.id = id;
        this.ciusuario = ciusuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.passwordd = passwordd;
        this.imagen = imagen;
        this.celular=celular;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCiusuario() {
        return ciusuario;
    }

    public void setCiusuario(String ciusuario) {
        this.ciusuario = ciusuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPasswordd() {
        return passwordd;
    }

    public void setPasswordd(String passwordd) {
        this.passwordd = passwordd;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
