package com.example.ccd_survey.Repositories;

import com.example.ccd_survey.Models.Evaluated;

import java.util.ArrayList;
import java.util.List;

public class EvaluationRepository {

    private static List<List<Evaluated>> evaluatedsPorPregunta = new ArrayList<>();

    public static void addEvaluatedsPorPregunta(int idpregunta, List<Evaluated> evaluateds) {

        evaluatedsPorPregunta.set(idpregunta, evaluateds);
        //evaluatedsPorPregunta.set()
    }

    public void validarSurvey(){

    }
}
