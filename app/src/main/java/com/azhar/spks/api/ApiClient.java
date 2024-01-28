package com.azhar.spks.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://sazaraaxm.000webhostapp.com/ds_perhitungan/";
    private static Retrofit retro;
    public static Retrofit getClient() {
        if (retro == null) {
            retro = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
