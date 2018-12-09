package com.thampotter.vi.musicspotify.Service;

public class APIService  {

    private static String baseURL = "https://androidzing.000webhostapp.com/Server/";

    public static DataService getService(){
        return APIRetrofitClient.getClient(baseURL).create(DataService.class);
    }
}
