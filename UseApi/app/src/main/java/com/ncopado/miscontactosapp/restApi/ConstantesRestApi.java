package com.ncopado.miscontactosapp.restApi;

import java.net.PortUnreachableException;

/**
 * Created by ncopado on 20/09/17.
 */

public final class ConstantesRestApi {

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=6068305501.531bf24.8f86cd2ebc9f47feb261ed7956ee6faa
    public static final  String VERSION="/v1/";
    public static final  String ROOT_URL="https://api.instagram.com" + VERSION;
    public static final  String ACCES_TOKEN="6068305501.531bf24.8f86cd2ebc9f47feb261ed7956ee6faa";
    public static final  String KEY_ACCESS_TOKEN="?access_token=";
    public static final  String KEY_GET_RECENT_MEDIA_USER="users/self/media/recent/";
    public static final  String URL_GET_RECENT_MEDIA_USER=KEY_GET_RECENT_MEDIA_USER+KEY_ACCESS_TOKEN+ACCES_TOKEN;





}
