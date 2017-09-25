package com.ncopado.miscontactosapp.restApi.Model;

import com.ncopado.miscontactosapp.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by ncopado on 20/09/17.
 */

public class ContactoResponse {

    ArrayList<Contacto>contactos;



    public ArrayList<Contacto> getContactos() {
        return this.contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
