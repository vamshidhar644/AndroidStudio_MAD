package com.example.animationrotate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView i1 = findViewById(R.id.image1);
        Button rtLeft = findViewById(R.id.rtLeft);
        Button rtRight = findViewById(R.id.rtRight);

        rtLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotateleft);
                Animation zoomin = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                i1.startAnimation(animation);
                i1.startAnimation(zoomin);
            }
        });

        rtRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotateright);
                i1.startAnimation(animation);
            }
        });
    }
}