package com.example.ccd_survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Skill_Workteam_Activity extends AppCompatActivity {

    Button btnworkteam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill__workteam_);

        btnworkteam = findViewById(R.id.btn_workteam);
        btnworkteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workteam = new Intent(view.getContext(), Skill_Flexibility_Activity.class);
                startActivity(workteam);
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
