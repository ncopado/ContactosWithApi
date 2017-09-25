package com.ncopado.miscontactosapp.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ncopado.miscontactosapp.db.ConstructorContactos;
import com.ncopado.miscontactosapp.fragment.IRecyclerViewFragmentView;
import com.ncopado.miscontactosapp.pojo.Contacto;
import com.ncopado.miscontactosapp.restApi.EndPointApi;
import com.ncopado.miscontactosapp.restApi.Model.ContactoResponse;
import com.ncopado.miscontactosapp.restApi.adapter.RestApiAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ncopado on 11/09/17.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private  IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private  Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
       // obtenerContactos();

        obtenerMediosRecientes();

    }

    @Override
    public void obtenerContactos() {
        constructorContactos=new ConstructorContactos(context);

        contactos= constructorContactos.obtenerDatos();

        //mostrarDatos();


    }

    @Override
    public void mostrarDatos() {

        iRecyclerViewFragmentView.inicializarAdaptadorRv(iRecyclerViewFragmentView.crearAdaptatodr(contactos));
        //iRecyclerViewFragmentView.generarLinearLayoutVertical();
        iRecyclerViewFragmentView.generarGridLayoutVertical();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent=restApiAdapter.construyeGsonDeserializadorMediaRecent();

        EndPointApi endPointApi= restApiAdapter.establecerConexionRestApiIntagram(gsonMediaRecent);
        Call<ContactoResponse> contactoResponseCall= endPointApi.getRecentMedia();

      //  Gson gsonMediaRecent= restApiAdapter.construyeGsonDeserializadorMediaRecent();






        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                 ContactoResponse contactoResponse=  response.body();
                 contactos= contactoResponse.getContactos();
                mostrarDatos();

            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context,"No se pudo conectar",Toast.LENGTH_LONG).show();
                Log.e("xxx",t.toString());

            }
        });



    }
}
