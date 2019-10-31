package com.example.ccd_survey.Repositories;

import android.util.Log;

import com.example.ccd_survey.Activities.Question1Activity;
import com.example.ccd_survey.Models.Evaluated;

import java.util.ArrayList;
import java.util.List;

public class EvaluationRepository {

    private static final String TAG = Question1Activity.class.getSimpleName();


    public static List<List<Evaluated>> evaluatedsPorPregunta = new ArrayList<>();

    //private static List<Evaluated> vacia = new ArrayList<>();


    public static void addEvaluatedsPorPregunta(int idpregunta, List<Evaluated> evaluateds) {

        evaluatedsPorPregunta.add(evaluateds);
        evaluatedsPorPregunta.set(idpregunta, evaluateds);



        //evaluatedsPorPregunta.set()
    }

    public void validarSurvey(){

    }
}
