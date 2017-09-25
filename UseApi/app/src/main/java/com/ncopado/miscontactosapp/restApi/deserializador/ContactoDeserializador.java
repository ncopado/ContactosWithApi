package com.ncopado.miscontactosapp.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.ncopado.miscontactosapp.pojo.Contacto;
import com.ncopado.miscontactosapp.restApi.JsonKeys;
import com.ncopado.miscontactosapp.restApi.Model.ContactoResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by ncopado on 20/09/17.
 */

public class ContactoDeserializador implements JsonDeserializer<ContactoResponse> {
    @Override
    public ContactoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson= new Gson();
        ContactoResponse contactoResponse =   gson.fromJson(json,ContactoResponse.class);
        JsonArray contactoResponseData= json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        contactoResponse.setContactos(deserializarContactoJson(contactoResponseData));
        return contactoResponse;
    }


    private ArrayList<Contacto>  deserializarContactoJson(JsonArray contactoResponseData)
    {
        ArrayList<Contacto> contactos=new ArrayList<>();

        for (int i=0; i< contactoResponseData.size(); i++){


            JsonObject contactoResponDataObject=contactoResponseData.get(i).getAsJsonObject();


            JsonObject  userJson =contactoResponDataObject.getAsJsonObject(JsonKeys.USER);
            String id=userJson.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto=userJson.get(JsonKeys.USER_FULLNAME).getAsString();


            JsonObject  imgJson =contactoResponDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject  stdResolution =imgJson.getAsJsonObject(JsonKeys.MEDIA_STANDAR_RESOLUTION);
            String urlFoto=stdResolution.get(JsonKeys.MEDIA_URL).getAsString();


            JsonObject  likesJson =contactoResponDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes=likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Contacto currente=new Contacto();
            currente.setId(id);
            currente.setNombreCompleto(nombreCompleto);
            currente.setUrlFoto(urlFoto);
            currente.setLikes(likes);

            contactos.add(currente);






        }

        return  contactos;


    }
}
