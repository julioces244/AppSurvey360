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

public interface ApiService {

    String API_BASE_URL = "http://52.91.89.10/";

    @GET("api/getEvaluated")
    Call<List<Evaluated>> getEvaluated();

    @FormUrlEncoded
    @POST("api/login")
    Call<Evaluator> login(@Field("username") String username,
                          @Field("password") String password);


}
