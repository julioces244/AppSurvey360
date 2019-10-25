package com.example.ccd_survey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Skill_Innovation_Activity extends AppCompatActivity {
    private String TAG="Fallo en la raíz";
    private Button btninnovation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_skill__innovation_);
        }catch (Exception e){
            Log.e(TAG, "onCreateView", e);
            throw e;
        }


        btninnovation = findViewById(R.id.btn_innovation);
        btninnovation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inno = new Intent(view.getContext(), Innovation_Activity.class);
                startActivity(inno);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
