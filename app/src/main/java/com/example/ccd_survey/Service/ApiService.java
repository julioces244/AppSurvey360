package com.example.ccd_survey.Service;


import com.example.ccd_survey.Models.Evaluated;
import com.example.ccd_survey.Models.Evaluator;
import com.example.ccd_survey.Models.Respuesta;
import com.example.ccd_survey.ResponseMessage;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

public interface ApiService {

    String API_BASE_URL = "http://52.91.89.10/";

    @GET("api/getEvaluatedAll")
    Call<List<Evaluated>> getEvaluated();

    @FormUrlEncoded
    @POST("api/login")
    Call<Evaluator> login(@Field("username") String username,
                          @Field("password") String password);


    //Obteniendo lista de evaluados según el usuario que ingrese
    @Streaming
    @GET("api/getEvaluated2/{idself}")
    Call<List<Evaluated>> getEvaluatedMain(@Path("idself") Integer idcategory);


    @Multipart
    @POST("/api/v1/productos")
    Call<ResponseMessage> createProductoWithImage(
            @Part("nombre") RequestBody nombre,
            @Part("precio") RequestBody precio,
            @Part("detalles") RequestBody detalles
    );

    //@FormUrlEncoded
    @POST("/api/storeScore/{idevaluador}")
    Call<ResponseMessage> createScore(@Path("idevaluador") Integer idevaluator,
                                      @Body List<Respuesta> respuestas);




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
