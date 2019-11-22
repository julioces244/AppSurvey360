package com.example.ccd_survey.Repositories;

import android.util.Log;

import com.example.ccd_survey.Activities.Question1Activity;
import com.example.ccd_survey.Models.Evaluated;
import com.example.ccd_survey.Models.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class EvaluationRepository {

    private static final String TAG = Question1Activity.class.getSimpleName();


    public static List<List<Evaluated>> evaluatedsPorPregunta = new ArrayList<>();


    public static void addEvaluatedsPorPregunta(int idpregunta, List<Evaluated> evaluateds) {

        evaluatedsPorPregunta.add(evaluateds);
        evaluatedsPorPregunta.set(idpregunta, evaluateds);



        //evaluatedsPorPregunta.set()
    }

    public void validarSurvey(){

    }


    public List<Respuesta> getRespuestas() {
        List<Respuesta> respuestas = new ArrayList<>();



        // Crear la lista de evaluados List<Respuesta> respuestas
        for (List<Evaluated> evaluados: evaluatedsPorPregunta) {

            for(Evaluated evaluado : evaluados) {

                // Buscar si ya estpa el evaluado en lista
                boolean yaexiste = false;
                for(Respuesta respuesta : respuestas) {
                    if(respuesta.getEvaluadoid() == evaluado.getIdEvaluated()) {
                        yaexiste = true;
                    }
                }

                if(!yaexiste) {
                    Respuesta respuesta = new Respuesta();
                    respuesta.setEvaluadoid(evaluado.getIdEvaluated());
                    respuestas.add(respuesta);
                }

            }

        }

        // Setear valor seleccionado de cada pregunta
        for(Respuesta respuesta : respuestas) {

            // Pregunta #1
            List<Evaluated> evaluados = evaluatedsPorPregunta.get(0);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta1(evaluadted.getCorrecta());
                }
            }

            // Pregunta #2
            evaluados = evaluatedsPorPregunta.get(1);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta2(evaluadted.getCorrecta());
                }
            }

            // Pregunta #3
            evaluados = evaluatedsPorPregunta.get(2);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta3(evaluadted.getCorrecta());
                }
            }

            // Pregunta #4
            evaluados = evaluatedsPorPregunta.get(3);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta4(evaluadted.getCorrecta());
                }
            }

            // Pregunta #5
            evaluados = evaluatedsPorPregunta.get(4);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta5(evaluadted.getCorrecta());
                }
            }

            // Pregunta #6
            evaluados = evaluatedsPorPregunta.get(5);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta6(evaluadted.getCorrecta());
                }
            }

            // Pregunta #7
            evaluados = evaluatedsPorPregunta.get(6);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta7(evaluadted.getCorrecta());
                }
            }

            // Pregunta #8
            evaluados = evaluatedsPorPregunta.get(7);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta8(evaluadted.getCorrecta());
                }
            }

            // Pregunta #9
            evaluados = evaluatedsPorPregunta.get(8);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta9(evaluadted.getCorrecta());
                }
            }

            // Pregunta #10
            evaluados = evaluatedsPorPregunta.get(9);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta10(evaluadted.getCorrecta());
                }
            }

            // Pregunta #11
            evaluados = evaluatedsPorPregunta.get(10);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta11(evaluadted.getCorrecta());
                }
            }

            // Pregunta #12
            evaluados = evaluatedsPorPregunta.get(11);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta12(evaluadted.getCorrecta());
                }
            }

            // Pregunta #13
            evaluados = evaluatedsPorPregunta.get(12);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta13(evaluadted.getCorrecta());
                }
            }

            // Pregunta #14
            evaluados = evaluatedsPorPregunta.get(13);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta14(evaluadted.getCorrecta());
                }
            }

            // Pregunta #15
            evaluados = evaluatedsPorPregunta.get(14);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta15(evaluadted.getCorrecta());
                }
            }

            // Pregunta #16
            evaluados = evaluatedsPorPregunta.get(15);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta16(evaluadted.getCorrecta());
                }
            }

            // Pregunta #17
            evaluados = evaluatedsPorPregunta.get(16);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta17(evaluadted.getCorrecta());
                }
            }

            // Pregunta #18
            evaluados = evaluatedsPorPregunta.get(17);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta18(evaluadted.getCorrecta());
                }
            }

            // Pregunta #19
            evaluados = evaluatedsPorPregunta.get(18);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta19(evaluadted.getCorrecta());
                }
            }

            // Pregunta #20
            evaluados = evaluatedsPorPregunta.get(19);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta20(evaluadted.getCorrecta());
                }
            }

            // Pregunta #21
            evaluados = evaluatedsPorPregunta.get(20);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta21(evaluadted.getCorrecta());
                }
            }

            // Pregunta #22
            evaluados = evaluatedsPorPregunta.get(21);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta22(evaluadted.getCorrecta());
                }
            }

            // Pregunta #23
            evaluados = evaluatedsPorPregunta.get(22);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta23(evaluadted.getCorrecta());
                }
            }

            // Pregunta #24
            evaluados = evaluatedsPorPregunta.get(23);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta24(evaluadted.getCorrecta());
                }
            }

            // Pregunta #25
            evaluados = evaluatedsPorPregunta.get(24);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta25(evaluadted.getCorrecta());
                }
            }

            // Pregunta #26
            evaluados = evaluatedsPorPregunta.get(25);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta26(evaluadted.getCorrecta());
                }
            }

            // Pregunta #27
            evaluados = evaluatedsPorPregunta.get(26);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta27(evaluadted.getCorrecta());
                }
            }

            // Pregunta #28
            evaluados = evaluatedsPorPregunta.get(27);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta28(evaluadted.getCorrecta());
                }
            }

            // Pregunta #29
            evaluados = evaluatedsPorPregunta.get(28);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta29(evaluadted.getCorrecta());
                }
            }

            // Pregunta #30
            evaluados = evaluatedsPorPregunta.get(29);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta30(evaluadted.getCorrecta());
                }
            }

            // Pregunta #31
            evaluados = evaluatedsPorPregunta.get(30);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta31(evaluadted.getCorrecta());
                }
            }

            // Pregunta #32
            evaluados = evaluatedsPorPregunta.get(31);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta32(evaluadted.getCorrecta());
                }
            }

            // Pregunta #33
            evaluados = evaluatedsPorPregunta.get(32);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta33(evaluadted.getCorrecta());
                }
            }

            // Pregunta #34
            evaluados = evaluatedsPorPregunta.get(33);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta34(evaluadted.getCorrecta());
                }
            }

            // Pregunta #35
            evaluados = evaluatedsPorPregunta.get(34);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta35(evaluadted.getCorrecta());
                }
            }

            // Pregunta #36
            evaluados = evaluatedsPorPregunta.get(35);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta36(evaluadted.getCorrecta());
                }
            }

            // Pregunta #37
            evaluados = evaluatedsPorPregunta.get(36);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta37(evaluadted.getCorrecta());
                }
            }

            // Pregunta #38
            evaluados = evaluatedsPorPregunta.get(37);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta38(evaluadted.getCorrecta());
                }
            }

            // Pregunta #39
            evaluados = evaluatedsPorPregunta.get(38);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta39(evaluadted.getCorrecta());
                }
            }

            // Pregunta #40
            evaluados = evaluatedsPorPregunta.get(39);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta40(evaluadted.getCorrecta());
                }
            }

            // Pregunta #41
            evaluados = evaluatedsPorPregunta.get(40);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta41(evaluadted.getCorrecta());
                }
            }

            // Pregunta #42
            evaluados = evaluatedsPorPregunta.get(41);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta42(evaluadted.getCorrecta());
                }
            }

            // Pregunta #43
            evaluados = evaluatedsPorPregunta.get(42);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta43(evaluadted.getCorrecta());
                }
            }

            // Pregunta #44
            evaluados = evaluatedsPorPregunta.get(43);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta44(evaluadted.getCorrecta());
                }
            }

            // Pregunta #45
            evaluados = evaluatedsPorPregunta.get(44);
            for (Evaluated evaluadted: evaluados) {
                if(evaluadted.getIdEvaluated() == respuesta.getEvaluadoid()) {
                    respuesta.setPregunta45(evaluadted.getCorrecta());
                }
            }

        }

        return respuestas;
    }
}
