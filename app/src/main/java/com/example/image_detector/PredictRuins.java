package com.example.image_detector;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.image_detector.ml.Model;
import com.example.image_detector.ml.StatuePredictionModel;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class PredictRuins extends AppCompatActivity {

    Button camera, gallery, view3D;
    ImageView imageView;
    TextView result, detail;
    int imageSize = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_predict_ruins);

        camera = findViewById(R.id.button);
        gallery = findViewById(R.id.button2);
        view3D = findViewById(R.id.button3);

        result = findViewById(R.id.result);
        detail = findViewById(R.id.detailText);
        imageView = findViewById(R.id.imageView);

        camera.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, 3);
                } else {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
                }
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(cameraIntent, 1);
            }
        });

        view3D.setOnClickListener(v -> {
            String sName = result.getText().toString();
            if (sName == "palace complex of king nissanka") {
                Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://github.com/ashmhmd25321/3D_Models/blob/main/model_build.glb?raw=true"));
                sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
                startActivity(sceneViewerIntent);
            } else if(sName == "sigiriya") {
                Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://github.com/ashmhmd25321/3D_Models/blob/main/sigiriya.glb?raw=true"));
                sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
                startActivity(sceneViewerIntent);
            }else if (sName == "sathmahal palace") {
                Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://github.com/bhashanaliyanage/ResearchJune/blob/main/Stamahal%2BPrasadaya.glb?raw=true"));
                sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
                startActivity(sceneViewerIntent);
            }else {
                Toast.makeText(this,"There are no 3D model for the selected.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void classifyImage(Bitmap image){
        try {
            Model model = Model.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 32, 32, 3}, DataType.FLOAT32);

            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());


            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
            int pixel = 0;

            //iterate over each pixel and extract R, G, and B values. Add those values individually to the byte buffer.
            for(int i = 0; i < imageSize; i ++){
                for(int j = 0; j < imageSize; j++){
                    int val = intValues[pixel++]; // RGB
                    byteBuffer.putFloat(((val >> 16) & 0xFF) * (1.f / 1));
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 1));
                    byteBuffer.putFloat((val & 0xFF) * (1.f / 1));
                }
            }

            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            Model.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidences = outputFeature0.getFloatArray();
            int maxPos = 0;
            float maxConfidence = 0;
            for (int i = 0; i < confidences.length; i++) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i];
                    maxPos = i;
                }
            }

            String[] classes = {"abayagiriya", "janthagara", "jethawanaya", "kuttam pokuna", "lowamahapaya", "palace complex of king nissanka", "ritigala", "sathmahal palace", "sigiriya", "thiriyaya Girihandu Seya"};
            result.setText(classes[maxPos]);
            String res = result.getText().toString();
            detail.setVisibility(View.VISIBLE);

            if (res.equals("abayagiriya")) {
                detail.setText("Abayagiriya is an ancient Buddhist monastery and archaeological site located in Anuradhapura, Sri Lanka.");
            } else if (res.equals("janthagara")) {
                detail.setText("Janthagarain is a historic Buddhist temple located in Sri Lanka known for its architectural beauty and religious significance.");
            }else if (res.equals("jethawanaya")) {
                detail.setText("Jethawanaya is an ancient Buddhist stupa located in Sri Lanka, known for its historical and architectural significance.");
            } else if (res.equals("kuttam pokuna")) {
                detail.setText("Kuttam Pokuna, also known as the Twin Ponds, is a historic bathing complex in Sri Lanka known for its impressive twin pools that date back to ancient times.");
            } else if (res.equals("lowamahapaya")) {
                detail.setText("The Lohamahapaya, also known as the Brazen Palace, is an ancient building located in Sri Lanka that once served as a monastery and assembly hall for Buddhist monks.");
            } else if (res.equals("palace complex of king nissanka")) {
                detail.setText("The palace complex of King Nissanka was a grand and opulent royal residence in ancient Sri Lanka.");
            } else if (res.equals("ritigala")) {
                detail.setText("Ritigala is an ancient Buddhist monastery located in Sri Lanka, known for its architectural ruins and natural beauty.");
            } else if (res.equals("sathmahal palace")) {
                detail.setText("Sathmahal Palace is a historic palace in Sri Lanka known for its architectural beauty and cultural significance.");
            } else if (res.equals("sigiriya")) {
                detail.setText("Sigiriya is an ancient rock fortress located in Sri Lanka known for its historical and archaeological significance.");
            } else if (res.equals("thiriyaya Girihandu Seya")) {
                detail.setText("Thiriyaya Girihandu Seya is an ancient Buddhist stupa located in Thiriyaya, Sri Lanka, believed to be built by King Mahasena in the 3rd century BC.");
            } else {
                detail.setText("");
            }
            // Releases model resources if no longer used.
            model.close();

        } catch (IOException e) {
            // TODO Handle the exception
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 3){
                Bitmap image = (Bitmap) data.getExtras().get("data");
                int dimension = Math.min(image.getWidth(), image.getHeight());
                image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);
            }else{
                Uri dat = data.getData();
                Bitmap image = null;
                try {
                    image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), dat);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}