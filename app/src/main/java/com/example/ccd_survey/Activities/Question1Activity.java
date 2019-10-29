package com.example.ccd_survey.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ccd_survey.Adapters.EvaluatedAdapter;
import com.example.ccd_survey.Models.Evaluated;
import com.example.ccd_survey.R;
import com.example.ccd_survey.Service.ApiService;
import com.example.ccd_survey.Service.ApiServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.ccd_survey.MainActivity.PREFS_NAME;

public class Question1Activity extends AppCompatActivity {

    private static final String TAG = Question1Activity.class.getSimpleName();

    private RecyclerView evaluatedList;

    Integer id_user;
    Integer id_category;
    //Integer idCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        evaluatedList = findViewById(R.id.recycler_question1);
        evaluatedList.setLayoutManager(new LinearLayoutManager(this));
        evaluatedList.setAdapter(new EvaluatedAdapter());

        //View v = evaluatedList.getLayoutManager().findViewByPosition(0);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        id_category = sharedPref.getInt("key_idcategory",0);

        Log.d(TAG, "CODIGO CATEGORIA: " + id_category);

        /*

        switch(id_category) {
            case 16:
                logindirectivo();
                break;
            case 15:
                loginsoportelima();
                break;
            case 14:
                loginsoportepisco();
                break;
            case 13:
                loginjefedigitaltecnologia();
                break;
            case 12:
                loginjefeaprendizaje();
                break;
            case 10:
                loginespecialistatecnologia();
                break;
            case 9:
                loginespecialistadigital();
                break;
            case 8:
                loginespecialistaaprendizaje();
                break;
        }*/


        initialize();

    }

    private void initialize(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Evaluated>> call = service.getEvaluatedMain(id_category);

        call.enqueue(new Callback<List<Evaluated>>() {
            @Override
            public void onResponse(Call<List<Evaluated>> call, Response<List<Evaluated>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Evaluated> evaluateds = response.body();
                        Log.d(TAG, "evaluateds: " + evaluateds);

                        EvaluatedAdapter adapter = (EvaluatedAdapter) evaluatedList.getAdapter();
                        adapter.setEvaluateds(evaluateds);
                        adapter.notifyDataSetChanged();



                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Evaluated>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }


    private void logindirectivo(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Evaluated>> call = service.getEvaluatedDirectivo();

        call.enqueue(new Callback<List<Evaluated>>() {
            @Override
            public void onResponse(Call<List<Evaluated>> call, Response<List<Evaluated>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Evaluated> evaluateds = response.body();
                        Log.d(TAG, "evaluateds: " + evaluateds);

                        EvaluatedAdapter adapter = (EvaluatedAdapter) evaluatedList.getAdapter();
                        adapter.setEvaluateds(evaluateds);
                        adapter.notifyDataSetChanged();



                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Evaluated>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }


    private void loginjefeaprendizaje(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Evaluated>> call = service.getEvaluatedJefeaprendizaje();

        call.enqueue(new Callback<List<Evaluated>>() {
            @Override
            public void onResponse(Call<List<Evaluated>> call, Response<List<Evaluated>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Evaluated> evaluateds = response.body();
                        Log.d(TAG, "evaluateds: " + evaluateds);

                        EvaluatedAdapter adapter = (EvaluatedAdapter) evaluatedList.getAdapter();
                        adapter.setEvaluateds(evaluateds);
                        adapter.notifyDataSetChanged();



                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Evaluated>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }

    private void loginjefedigitaltecnologia(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Evaluated>> call = service.getEvaluatedJededigitaltecnologia();

        call.enqueue(new Callback<List<Evaluated>>() {
            @Override
            public void onResponse(Call<List<Evaluated>> call, Response<List<Evaluated>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Evaluated> evaluateds = response.body();
                        Log.d(TAG, "evaluateds: " + evaluateds);

                        EvaluatedAdapter adapter = (EvaluatedAdapter) evaluatedList.getAdapter();
                        adapter.setEvaluateds(evaluateds);
                        adapter.notifyDataSetChanged();



                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Evaluated>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }

    private void loginsoportepisco(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Evaluated>> call = service.getEvaluatedSoportepisco();

        call.enqueue(new Callback<List<Evaluated>>() {
            @Override
            public void onResponse(Call<List<Evaluated>> call, Response<List<Evaluated>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Evaluated> evaluateds = response.body();
                        Log.d(TAG, "evaluateds: " + evaluateds);

                        EvaluatedAdapter adapter = (EvaluatedAdapter) evaluatedList.getAdapter();
                        adapter.setEvaluateds(evaluateds);
                        adapter.notifyDataSetChanged();



                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Evaluated>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }

    private void loginsoportelima(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Evaluated>> call = service.getEvaluatedSoportelima();

        call.enqueue(new Callback<List<Evaluated>>() {
            @Override
            public void onResponse(Call<List<Evaluated>> call, Response<List<Evaluated>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Evaluated> evaluateds = response.body();
                        Log.d(TAG, "evaluateds: " + evaluateds);

                        EvaluatedAdapter adapter = (EvaluatedAdapter) evaluatedList.getAdapter();
                        adapter.setEvaluateds(evaluateds);
                        adapter.notifyDataSetChanged();



                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Evaluated>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }

    private void loginespecialistaaprendizaje(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Evaluated>> call = service.getEvaluatedEspecialistaaprendizaje();

        call.enqueue(new Callback<List<Evaluated>>() {
            @Override
            public void onResponse(Call<List<Evaluated>> call, Response<List<Evaluated>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Evaluated> evaluateds = response.body();
                        Log.d(TAG, "evaluateds: " + evaluateds);

                        EvaluatedAdapter adapter = (EvaluatedAdapter) evaluatedList.getAdapter();
                        adapter.setEvaluateds(evaluateds);
                        adapter.notifyDataSetChanged();



                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Evaluated>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }

    private void loginespecialistadigital(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Evaluated>> call = service.getEvaluatedEspecialistadigital();

        call.enqueue(new Callback<List<Evaluated>>() {
            @Override
            public void onResponse(Call<List<Evaluated>> call, Response<List<Evaluated>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Evaluated> evaluateds = response.body();
                        Log.d(TAG, "evaluateds: " + evaluateds);

                        EvaluatedAdapter adapter = (EvaluatedAdapter) evaluatedList.getAdapter();
                        adapter.setEvaluateds(evaluateds);
                        adapter.notifyDataSetChanged();



                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Evaluated>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }

    private void loginespecialistatecnologia(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Evaluated>> call = service.getEvaluatedEspecialistatecnologia();

        call.enqueue(new Callback<List<Evaluated>>() {
            @Override
            public void onResponse(Call<List<Evaluated>> call, Response<List<Evaluated>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Evaluated> evaluateds = response.body();
                        Log.d(TAG, "evaluateds: " + evaluateds);

                        EvaluatedAdapter adapter = (EvaluatedAdapter) evaluatedList.getAdapter();
                        adapter.setEvaluateds(evaluateds);
                        adapter.notifyDataSetChanged();



                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Evaluated>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }

    private void logindcoordinadoraprendizaje(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Evaluated>> call = service.getEvaluatedCoordinadoraprendizaje();

        call.enqueue(new Callback<List<Evaluated>>() {
            @Override
            public void onResponse(Call<List<Evaluated>> call, Response<List<Evaluated>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Evaluated> evaluateds = response.body();
                        Log.d(TAG, "evaluateds: " + evaluateds);

                        EvaluatedAdapter adapter = (EvaluatedAdapter) evaluatedList.getAdapter();
                        adapter.setEvaluateds(evaluateds);
                        adapter.notifyDataSetChanged();



                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Evaluated>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Question1Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }


}

