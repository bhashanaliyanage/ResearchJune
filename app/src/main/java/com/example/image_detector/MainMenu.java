package com.example.image_detector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainMenu extends AppCompatActivity {

    LinearLayout pStatues,pRuins, pTemples, chatBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        pStatues = findViewById(R.id.predict_statues);
        pRuins = findViewById(R.id.predict_ruins);
        pTemples = findViewById(R.id.predict_temple);
        chatBot = findViewById(R.id.chatbot);

        pStatues.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        chatBot.setOnClickListener(v -> {
            Intent intent = new Intent(this, ChatBot.class);
            startActivity(intent);
        });

        pRuins.setOnClickListener(v -> {
            Intent intent = new Intent(this, PredictRuins.class);
            startActivity(intent);
        });

        pTemples.setOnClickListener(v -> {
            Intent intent = new Intent(this, PredictStupa.class);
            startActivity(intent);
        });
    }
}