package com.artificial_intelligent.johnmelodyme.cindyai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @Author : John Melody Melissa
 * @Copyright: ALL RIGHT RESERVED  © 2020 JOHN MELODY MELISSA COPYRIGHT ❤️
 * @INPIREDBYGF :  SinDee, {Is a Virtual Assistant Name after My GF} ❤️
 */

public class CindyActivity extends AppCompatActivity {
    private static final String TAG = "Cindy";
    private static Button Activate;
    private static TextToSpeech textToSpeech;
    private static SpeechRecognizer speechRecognizer;
    public Context Cindy = CindyActivity.this;
    private static Date date;
    private static Calendar calendar;

    // TODO DeclaractionInit()
    public void DeclaractionInit(){
        Activate = findViewById(R.id.activate);
        date = Calendar.getInstance().getTime();
        calendar = Calendar.getInstance();
    }

    @Override
    // TODO onCreate
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Starting " + CindyActivity.class.getName());
        DeclaractionInit();
        StartSpeechRecognition();
        StartTextToSpeech();
    }

    // TODO StartSpeechRecognition()
    public void StartSpeechRecognition() {
        if (SpeechRecognizer.isRecognitionAvailable(Cindy)){
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(Cindy);
            speechRecognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle params) {

                }

                @Override
                public void onBeginningOfSpeech() {

                }

                @Override
                public void onRmsChanged(float rmsdB) {

                }

                @Override
                public void onBufferReceived(byte[] buffer) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int error) {

                }

                @Override
                public void onResults(Bundle bundle) {
                    ArrayList<? extends String> results;
                    results = bundle.getParcelableArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                    if(results != null){
                        processResult(results);
                    }
                }

                @Override
                public void onPartialResults(Bundle partialResults) {

                }

                @Override
                public void onEvent(int eventType, Bundle params) {

                }
            });
        }
    }

    //TODO StartTextToSpeech()
    public void StartTextToSpeech() {
        textToSpeech = new TextToSpeech(Cindy, new OnInitListener() {
            @Override
            public void onInit(int status) {
                if (textToSpeech.getEngines().size() == 0x0){
                    String MSG, URL;
                    Intent INSTALL_TTS;
                    MSG = getResources().getString(R.string.installtts);
                    URL = getResources().getString(R.string.urltoinstalltts);

                    Toast.makeText(Cindy,MSG,
                            Toast.LENGTH_SHORT)
                            .show();

                    INSTALL_TTS = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                    startActivity(INSTALL_TTS);
                    ClearOut();
                } else {
                    String CINDYBEGINTOSAY;
                    CINDYBEGINTOSAY = getResources().getString(R.string.initmsg);
                    textToSpeech.setLanguage(Locale.UK);
                    CindySay(CINDYBEGINTOSAY);
                }
            }
        });
    }

    // TODO processResult:
    private void processResult(ArrayList<? extends String> command) {

        if(command.contains("testing")){
            CindySay("it is working");
        }
    }

    // TODO CIndySay()
    @SuppressLint("ObsoleteSdkInt")
    public static void CindySay(String message){
        if (Build.VERSION.SDK_INT > 0x13){
            textToSpeech.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            textToSpeech.speak(message, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    // TODO Microphone()
    public static void Microphone(){
        Intent SPEECH_RECOGNIZER;
        SPEECH_RECOGNIZER = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        SPEECH_RECOGNIZER.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        SPEECH_RECOGNIZER.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
        speechRecognizer.startListening(SPEECH_RECOGNIZER);
    }

    // TODO ClearOut()
    public void ClearOut(){
        System.gc();
        finish();
    }
}
