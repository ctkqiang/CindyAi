package com.artificial_intelligent.johnmelodyme.cindyai;

import android.content.Context;
import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

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
    }

    public void StartSpeechRecognition() {
        Context Cindy = CindyActivity.this;
        if (SpeechRecognizer.isRecognitionAvailable(Cindy)){

        }
    }
}
