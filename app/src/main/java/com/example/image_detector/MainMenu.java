package com.example.image_detector;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainMenu extends AppCompatActivity {

    ConstraintLayout pStatues,pRuins, pTemples, chatBot;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
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