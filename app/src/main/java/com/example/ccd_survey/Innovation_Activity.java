package com.example.ccd_survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Innovation_Activity extends AppCompatActivity {

    private Button btninnovation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innovation_);

        spinner1();
        spinner2();
        spinner3();
        spinner4();
        spinner5();
        spinner6();

        btninnovation = findViewById(R.id.btn_innovatione1);
        btninnovation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inno = new Intent(view.getContext(), Innovation2_Activity.class);
                startActivity(inno);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }


    private void  spinner1(){

        Spinner spinner = findViewById(R.id.spn_innovatione_q1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.answers, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    private void  spinner2(){

        Spinner spinner = findViewById(R.id.spn_innovatione_q2);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.answers, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    private void  spinner3(){

        Spinner spinner = findViewById(R.id.spn_innovatione_q3);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.answers, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    private void  spinner4(){

        Spinner spinner = findViewById(R.id.spn_innovatione_q4);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.answers, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    private void spinner5(){

        Spinner spinner = findViewById(R.id.spn_innovatione_q5);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.answers, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    private void spinner6(){

        Spinner spinner = findViewById(R.id.spn_innovatione_q6);
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
