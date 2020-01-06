package com.example.login_register_with_api.apihelper;

public class UtilsApi {

    // 192.168.1.5 ini adalah localhost.
    public static final String BASE_URL_API = "http://192.168.1.5/API_Login_Register/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
