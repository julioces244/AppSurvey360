package com.example.ccd_survey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccd_survey.Activities.Question1Activity;
import com.example.ccd_survey.Models.Evaluator;
import com.example.ccd_survey.Service.ApiService;
import com.example.ccd_survey.Service.ApiServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "PermissionDemo";
    private TextView txtProgress;
    private ProgressBar progressBar;
    private EditText et_username, et_password;
    private int pStatus = 0;
    private Handler handler = new Handler();
    private static final int RECORD_REQUEST_CODE = 101;
    private RelativeLayout main_login;

    public static final String PREFS_NAME = "MyApp";

    private Integer idEvaluator, idCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtProgress = (TextView) findViewById(R.id.txtProgress);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);


        permissionAudio();

        Button btn = findViewById(R.id.btn_login);

        main_login = findViewById(R.id.relative_login);





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ingresar();

            }
        });

    }


    public void ingresar(){

        String username = et_username.getText().toString();
        String passowrd = et_password.getText().toString();


        if (username.isEmpty() || passowrd.isEmpty()) {
            Toast.makeText(this, "Username y Password son requeridos", Toast.LENGTH_SHORT).show();
            return;
        }


        ApiService service = ApiServiceGenerator.createService(ApiService.class);
        Call<Evaluator> call = null;
        call = service.login(username, passowrd);

        call.enqueue(new Callback<Evaluator>() {
            @Override
            public void onResponse(Call<Evaluator> call, Response<Evaluator> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        final Evaluator responseMessage = response.body();
                        Log.d(TAG, "responseMessage: " + responseMessage);

                        Toast.makeText(MainActivity.this, "Hola "+responseMessage.getName() , Toast.LENGTH_LONG).show();

                        progressBar.setVisibility(View.VISIBLE);
                        main_login.setVisibility(View.INVISIBLE);

                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                while (pStatus <= 100) {
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            progressBar.setProgress(pStatus);
                                            txtProgress.setText(pStatus + " %");
                                        }
                                    });
                                    try {
                                        Thread.sleep(25);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    pStatus++;
                                }

                                idEvaluator = responseMessage.getIdEvaluator();
                                idCategory = responseMessage.getCategory_id();

                                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putInt("key_id",idEvaluator);
                                editor.putInt("key_idcategory", idCategory);
                                editor.commit();



                                Intent login = new Intent(MainActivity.this, Question1Activity.class);
                                startActivity(login);
                            }
                        }).start();


                        //finish();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (Throwable x) {
                    }
                }
            }

            @Override
            public void onFailure(Call<Evaluator> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });





    }


    private void permissionAudio(){

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.RECORD_AUDIO},
                    RECORD_REQUEST_CODE);}


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RECORD_REQUEST_CODE: {

                if (grantResults.length == 0
                        || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {

                    Log.i(TAG, "Permission has been denied by user");
                } else {
                    Log.i(TAG, "Permission has been granted by user");
                }
                return;
            }
        }
    }

}