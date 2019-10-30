package com.example.ccd_survey.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ccd_survey.MainActivity;
import com.example.ccd_survey.R;
import com.tomer.fadingtextview.FadingTextView;

import java.util.concurrent.TimeUnit;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;


public class ChatbotFragment extends Fragment implements AIListener {


    public ChatbotFragment() {
        // Required empty public constructor
    }

    private String[] changeText = {"Escuchando.", "Escuchando..", "Escuchando..."};
    private String[] changeText2 = {"Presiona y dime Hola"};
    private TextToSpeech mTextToSpeech;
    private AIService mAIService;
    private FadingTextView txt_cb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //changeText();


        final AIConfiguration config = new AIConfiguration("9cec2948e67d41b0b5e4fbbd57ce1787",
                AIConfiguration.SupportedLanguages.Spanish,
                AIConfiguration.RecognitionEngine.System);

        mAIService = AIService.getService(getActivity(), config);
        mAIService.setListener(this);

        mTextToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chatbot, container, false);

        txt_cb = (FadingTextView) view.findViewById(R.id.txt_chatbot);

        view.findViewById(R.id.btn_microphone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txt_cb.setTimeout(150, TimeUnit.MILLISECONDS);
                txt_cb.setTexts(changeText);

                mAIService.startListening();
            }
        });

        return view;
    }

    public void changeText(){



    }


    @Override
    public void onResult(AIResponse response) {


        Result result = response.getResult();

        mTextToSpeech.speak(result.getFulfillment().getSpeech(), TextToSpeech.QUEUE_FLUSH, null, null);

        String[] chattext = {result.getFulfillment().getSpeech()};
        txt_cb.setTimeout(1000, TimeUnit.MILLISECONDS);
        txt_cb.setTexts(chattext);

        if(chattext.equals("Salir")){
            Intent logout = new Intent(getActivity(), MainActivity.class);
            startActivity(logout);
        }


    }

    @Override
    public void onError(AIError error) {

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
