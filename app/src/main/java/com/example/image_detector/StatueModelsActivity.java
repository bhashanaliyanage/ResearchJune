package com.example.image_detector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;

public class StatueModelsActivity extends AppCompatActivity {

    Button statue02;
    TextView text;

    String[] names = {"Nuwaraeliya Buddha Statue", "Statue of Shiva", "Athugala Buddha Statue"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_models);

        statue02 = findViewById(R.id.statue2);
        text = findViewById(R.id.text);

        text.setVisibility(View.INVISIBLE);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);

        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item,names);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                text.setText(item);
            }
        });

        statue02.setOnClickListener(view -> {
            String sName = text.getText().toString();
            if (sName == "Nuwaraeliya Buddha Statue") {
                Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://github.com/bhashanaliyanage/ResearchJune/blob/main/nuwaraeliyaBuddhastatue.glb?raw=true"));
                sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
                startActivity(sceneViewerIntent);
            } else if(sName == "Statue of Shiva") {
                Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://github.com/bhashanaliyanage/ResearchJune/blob/main/shiva.glb?raw=true"));
                sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
                startActivity(sceneViewerIntent);
            } else if (sName == "Athugala Buddha Statue") {
                Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://github.com/bhashanaliyanage/ResearchJune/blob/main/Lord%20Buddha.glb?raw=true"));
                sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
                startActivity(sceneViewerIntent);
            }else {
                Toast.makeText(this,"Select a 3D model", Toast.LENGTH_SHORT).show();
            }
        });
    }
}