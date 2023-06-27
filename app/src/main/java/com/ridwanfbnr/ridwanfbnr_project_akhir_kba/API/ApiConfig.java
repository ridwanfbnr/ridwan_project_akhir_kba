package com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    static String BASE_URL = "http://himtiumt.org/backend_kelompok_belajar_android/index.php/API_tugas_akhir/";

    public static Retrofit getApiConfig() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService service = getApiConfig().create(ApiService.class);
}
