package com.example.ccd_survey.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ccd_survey.Adapters.EvaluatedAdapter;
import com.example.ccd_survey.Models.Evaluated;
import com.example.ccd_survey.R;
import com.example.ccd_survey.Repositories.EvaluationRepository;
import com.example.ccd_survey.Service.ApiService;
import com.example.ccd_survey.Service.ApiServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.ccd_survey.MainActivity.PREFS_NAME;

public class Question27Activity extends AppCompatActivity {

    private static final String TAG = Question1Activity.class.getSimpleName();

    private RecyclerView evaluatedList;

    Integer id_category;
    Button btn27;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question27);

        evaluatedList = findViewById(R.id.recycler_question1);
        evaluatedList.setLayoutManager(new LinearLayoutManager(this));
        evaluatedList.setAdapter(new EvaluatedAdapter());


        btn27 = findViewById(R.id.btn_question27);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        id_category = sharedPref.getInt("key_idcategory",0);

        next();
        initialize();
    }

    public void next() {

        btn27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EvaluatedAdapter adapter = (EvaluatedAdapter) evaluatedList.getAdapter();
                List<Evaluated> evaluates = adapter.getEvaluateds();

                EvaluationRepository examenRepository = new EvaluationRepository();
                //examenRepository.addEvaluatedsPorPregunta(1, evaluates);

                startActivity(new Intent(getApplication(), Question28Activity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

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
                        Toast.makeText(Question27Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Evaluated>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(Question27Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
