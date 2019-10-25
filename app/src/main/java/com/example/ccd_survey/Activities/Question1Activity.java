package com.example.ccd_survey.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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

public class Question1Activity extends AppCompatActivity {

    private static final String TAG = Question1Activity.class.getSimpleName();

    private RecyclerView evaluatedList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        evaluatedList = findViewById(R.id.recycler_question1);
        evaluatedList.setLayoutManager(new LinearLayoutManager(this));
        evaluatedList.setAdapter(new EvaluatedAdapter());

        initialize();

    }

    private void initialize(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Evaluated>> call = service.getEvaluated();

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

