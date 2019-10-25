package com.example.ccd_survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.androidviewhover.BlurLayout;

public class Experience_Activity extends AppCompatActivity {

    private Context mContext;
    private BlurLayout sampleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_);

        spinner1();
        spinner2();
        spinner3();

        Button btn_experience = findViewById(R.id.btn_experience1);
        btn_experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Experience2_Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });



        mContext = this;
        BlurLayout sampleLayout = (BlurLayout)findViewById(R.id.blur_layout4);
        View hover = LayoutInflater.from(mContext).inflate(R.layout.hover_sample, null);
        sampleLayout.setHoverView(hover);

        //View (R.id.heart) appear animation.
        sampleLayout.addChildAppearAnimator(hover, R.id.content, Techniques.BounceIn);
        //View (R.id.heart) disappear animation.
        sampleLayout.addChildDisappearAnimator(hover, R.id.content, Techniques.FadeOutUp);
    }

    private void spinner1(){
        Spinner spinner = findViewById(R.id.spn_experience_q3);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.answers, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void spinner2(){
        Spinner spinner = findViewById(R.id.spn_experience_q4);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.answers, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void spinner3(){
        Spinner spinner = findViewById(R.id.spn_experience_q5);
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
