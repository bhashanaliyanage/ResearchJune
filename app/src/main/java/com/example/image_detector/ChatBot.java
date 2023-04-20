package com.example.image_detector;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.samsao.messageui.views.MessagesWindow;

import java.util.ArrayList;

public class ChatBot extends AppCompatActivity {

    protected static final int RESULT_SPEECH = 1;
    private ImageButton btnSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        btnSpeak = findViewById(R.id.btnSpeak);

        // "context" must be an Activity, Service or Application object from your app.
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        MessagesWindow messagesWindow = (MessagesWindow) findViewById(R.id.customized_messages_window);
        Button send = findViewById(com.samsao.messageui.R.id.message_box_button);
        send.setBackgroundColor(Color.WHITE);
        send.setTextSize(14);
        send.setTextColor(Color.BLUE);
        EditText message = messagesWindow.getWritingMessageView().findViewById(com.samsao.messageui.R.id.message_box_text_field);
        message.setBackgroundColor(Color.WHITE);
        message.setHint("Type Here...");
        messagesWindow.setBackgroundResource(com.google.android.material.R.color.material_grey_850);
        messagesWindow.getWritingMessageView().findViewById(com.samsao.messageui.R.id.message_box_button).setOnClickListener(v -> {
            messagesWindow.sendMessage(message.getText().toString());

            Python py = Python.getInstance();

            PyObject pyObj = py.getModule("chatbot");

            PyObject obj = pyObj.callAttr("main", message.getText().toString());

            messagesWindow.receiveMessage(obj.toString());

            message.setText("");
        });

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    message.setText("");
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Your device doesn't support Speech to Text", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MessagesWindow messagesWindow = (MessagesWindow) findViewById(R.id.customized_messages_window);
        EditText message = messagesWindow.getWritingMessageView().findViewById(com.samsao.messageui.R.id.message_box_text_field);
        switch (requestCode){
            case RESULT_SPEECH:
                if(resultCode == RESULT_OK && data != null){
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    message.setText(text.get(0));
                }
                break;
        }
    }
}