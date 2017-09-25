package com.ncopado.miscontactosapp.restApi;

import com.ncopado.miscontactosapp.restApi.Model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ncopado on 20/09/17.
 */

public interface EndPointApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia();
}
