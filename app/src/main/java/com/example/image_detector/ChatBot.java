package com.example.image_detector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.samsao.messageui.views.MessagesWindow;

public class ChatBot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        // "context" must be an Activity, Service or Application object from your app.
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        MessagesWindow messagesWindow = (MessagesWindow) findViewById(R.id.customized_messages_window);
        EditText message = messagesWindow.getWritingMessageView().findViewById(com.samsao.messageui.R.id.message_box_text_field);

        message.setHint("Type Here...");
        messagesWindow.setBackgroundResource(com.google.android.material.R.color.design_default_color_primary_dark);

        messagesWindow.getWritingMessageView().findViewById(com.samsao.messageui.R.id.message_box_button).setOnClickListener(v -> {
            messagesWindow.sendMessage(message.getText().toString());

            Python py = Python.getInstance();

            PyObject pyObj = py.getModule("chatbot");

            PyObject obj = pyObj.callAttr("main", message.getText().toString());

            messagesWindow.receiveMessage(obj.toString());

            message.setText("");
        });

    }
}