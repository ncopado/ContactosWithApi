package com.ncopado.miscontactosapp.pojo;

/**
 * Created by ncopado on 18/08/17.
 */

public class Contacto {



    private String id;
    private String nombreCompleto;
    private  String urlFoto;
    private  int likes;

  /*  public Contacto(String nombre, String telefono) {
       this.Nombre = nombre;
        this.Telefono = telefono;
    }*/

    public Contacto(String urlfoto, String nombre, int likes) {
        this.urlFoto=urlfoto;
        this.nombreCompleto = nombre;
        this.likes=likes;

    }

    public Contacto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
