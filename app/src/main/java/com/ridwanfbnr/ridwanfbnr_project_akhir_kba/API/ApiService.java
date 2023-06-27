package com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API;

import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.models.film.ResponseFilm;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.models.login.ResponseLogin;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.models.register.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("getFilm")
    Call<ResponseFilm> getDataFilms();

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> requestLogin(@Field("email") String email,
                                     @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<ResponseRegister> requestRegister(@Field("username") String username,
                                           @Field("email") String email,
                                           @Field("password") String password);
}
