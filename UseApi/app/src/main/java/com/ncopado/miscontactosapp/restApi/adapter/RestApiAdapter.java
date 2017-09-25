package com.ncopado.miscontactosapp.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncopado.miscontactosapp.restApi.ConstantesRestApi;
import com.ncopado.miscontactosapp.restApi.EndPointApi;
import com.ncopado.miscontactosapp.restApi.Model.ContactoResponse;
import com.ncopado.miscontactosapp.restApi.deserializador.ContactoDeserializador;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ncopado on 20/09/17.
 */

public class RestApiAdapter {

    public EndPointApi establecerConexionRestApiIntagram(Gson gson){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return  retrofit.create(EndPointApi.class);
    }


    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class,new ContactoDeserializador());


        return gsonBuilder.create();

    }

}
