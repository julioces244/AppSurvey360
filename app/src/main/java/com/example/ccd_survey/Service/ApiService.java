package com.example.ccd_survey.Service;


import com.example.ccd_survey.Models.Evaluated;
import com.example.ccd_survey.Models.Evaluator;
import com.example.ccd_survey.ResponseMessage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    String API_BASE_URL = "http://52.91.89.10/";

    @GET("api/getEvaluatedAll")
    Call<List<Evaluated>> getEvaluated();

    @FormUrlEncoded
    @POST("api/login")
    Call<Evaluator> login(@Field("username") String username,
                          @Field("password") String password);


    //Obteniendo lista de evaluados según el usuario que ingrese

    @GET("api/getEvaluated/{idcategory}")
    Call<List<Evaluated>> getEvaluatedMain(@Path("idcategory") Integer idcategory);

    @GET("api/getEvaluatedDirectivo")
    Call<List<Evaluated>> getEvaluatedDirectivo();

    @GET("api/getEvaluatedSoportelima")
    Call<List<Evaluated>> getEvaluatedSoportelima();

    @GET("api/getEvaluatedSoportepisco")
    Call<List<Evaluated>> getEvaluatedSoportepisco();

    @GET("api/getEvaluatedJefeaprendizaje")
    Call<List<Evaluated>> getEvaluatedJefeaprendizaje();

    @GET("api/getEvaluatedJededigitaltecnologia")
    Call<List<Evaluated>> getEvaluatedJededigitaltecnologia();

    @GET("api/getEvaluatedEspecialistaaprendizaje")
    Call<List<Evaluated>> getEvaluatedEspecialistaaprendizaje();

    @GET("api/getEvaluatedEspecialistadigital")
    Call<List<Evaluated>> getEvaluatedEspecialistadigital();

    @GET("api/getEvaluatedEspecialistatecnologia")
    Call<List<Evaluated>> getEvaluatedEspecialistatecnologia();

    @GET("api/getEvaluatedCoordinadoraprendizaje")
    Call<List<Evaluated>> getEvaluatedCoordinadoraprendizaje();

    @GET("api/getEvaluatedCoordinadordigital")
    Call<List<Evaluated>> getEvaluatedCoordinadordigital();

    @GET("api/getEvaluatedCoordinadortecnologia")
    Call<List<Evaluated>> getEvaluatedCoordinadortecnologia();

    @GET("api/getEvaluatedAcompañanteaprendizaje")
    Call<List<Evaluated>> getEvaluatedAcompañanteaprendizaje();

    @GET("api/getEvaluatedAcompañantedigital")
    Call<List<Evaluated>> getEvaluatedAcompañantedigital();

    @GET("api/getEvaluatedAcompañantetecnologia")
    Call<List<Evaluated>> getEvaluatedAcompañantetecnologia();


}
