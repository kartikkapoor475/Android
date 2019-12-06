package com.example.imagelabel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabel;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabeler;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Button bt1,bt2;
    private int CAMERA_REQUEST=100;
    FirebaseVisionTextRecognizer detector;

    public  Bitmap image_detect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        image=findViewById(R.id.image);
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);


        detector= FirebaseVision.getInstance().getOnDeviceTextRecognizer();


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,CAMERA_REQUEST);



            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detectLabel(image_detect);
            }
        });



    }//oncreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if(requestCode==CAMERA_REQUEST)
            {
                Bundle extras=data.getExtras();
                    image_detect=(Bitmap) extras.get("data");
                        image.setImageBitmap(image_detect);
            }


    }


        public void detectLabel(Bitmap b)
        {


            FirebaseVisionImage f_image=FirebaseVisionImage.fromBitmap(image_detect);

            FirebaseVisionImageLabeler labeler=FirebaseVision.getInstance().getOnDeviceImageLabeler();

            labeler.processImage(f_image).addOnCompleteListener(new OnCompleteListener<List<FirebaseVisionImageLabel>>() {
                @Override
                public void onComplete(@NonNull Task<List<FirebaseVisionImageLabel>> task) {

                    String output="";
                    for(FirebaseVisionImageLabel labeld:task.getResult())
                    {
                        output+=labeld.getText()+"\t"+labeld.getConfidence()+"\n";
                    }

                   Toast.makeText(MainActivity.this, ""+output, Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                }
            });


        }

}//main activity
