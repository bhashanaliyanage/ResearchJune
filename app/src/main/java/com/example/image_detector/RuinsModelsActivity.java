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

public class RuinsModelsActivity extends AppCompatActivity {

    androidx.appcompat.widget.AppCompatButton statue02;
    TextView text;

    String[] names = {"Kaparamula", "Rathnapasada", "Moonstone in Anuradhapura", "Satmahal Prasadaya"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruins_models);

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
            if (sName == "Moonstone in Anuradhapura") {
                Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://github.com/bhashanaliyanage/ResearchJune/blob/main/Sandakada%2BPahana.glb?raw=true"));
                sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
                startActivity(sceneViewerIntent);
            } else if(sName == "Rathnapasada") {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://p3d.in/R3fBn/embed")); // replace the URL with the link to your Sketchfab model
                intent.setPackage("com.android.chrome"); // set the package of the web browser you want to use
                startActivity(intent);
            }else if(sName == "Kaparamula") {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://p3d.in/2qjnO/embed")); // replace the URL with the link to your Sketchfab model
                intent.setPackage("com.android.chrome"); // set the package of the web browser you want to use
                startActivity(intent);
            }else if (sName == "Satmahal Prasadaya") {
                Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://github.com/bhashanaliyanage/ResearchJune/blob/main/Stamahal%2BPrasadaya.glb?raw=true"));
                sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
                startActivity(sceneViewerIntent);
            }
        });
    }
}