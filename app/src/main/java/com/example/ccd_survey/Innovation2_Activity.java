package com.example.ccd_survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Innovation2_Activity extends AppCompatActivity {

    private Button btninnovation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innovation2_);

        spinner1();
        spinner2();
        spinner3();
        spinner4();

        btninnovation = findViewById(R.id.btn_innovatione2);
        btninnovation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inno = new Intent(view.getContext(), Skill_Results_Activity.class);
                startActivity(inno);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    private void  spinner1(){

        Spinner spinner = findViewById(R.id.spn_innovatione_q7);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.answers, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    private void  spinner2(){

        Spinner spinner = findViewById(R.id.spn_innovatione_q9);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.answers, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    private void  spinner3(){

        Spinner spinner = findViewById(R.id.spn_innovatione_q10);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.answers, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    private void  spinner4(){

        Spinner spinner = findViewById(R.id.spn_innovatione_q11);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.answers, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
