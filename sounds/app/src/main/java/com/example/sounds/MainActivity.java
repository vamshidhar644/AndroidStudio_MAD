package com.example.sounds;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageDrums, imageFlute, imageGuitar, imagePiano, imageTabla, imageViolin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageDrums = (ImageView) findViewById(R.id.imageDrums);
        imageFlute = (ImageView) findViewById(R.id.imageFlute);
        imageGuitar = (ImageView) findViewById(R.id.imageGuitar);
        imagePiano = (ImageView) findViewById(R.id.imagePiano);
        imageTabla = (ImageView) findViewById(R.id.imageTabla);
        imageViolin = (ImageView) findViewById(R.id.imageViolin);

        imageDrums.setOnClickListener(this);
        imageFlute.setOnClickListener(this);
        imageGuitar.setOnClickListener(this);
        imagePiano.setOnClickListener(this);
        imageTabla.setOnClickListener(this);
        imageViolin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageDrums:
                MediaPlayer drums = MediaPlayer.create(MainActivity.this, R.raw.drums);
                drums.start();
                break;
            case R.id.imageFlute:
                MediaPlayer flute = MediaPlayer.create(MainActivity.this, R.raw.flute);
                flute.start();
                break;
            case R.id.imageGuitar:
                MediaPlayer guitar = MediaPlayer.create(MainActivity.this, R.raw.guitar);
                guitar.start();
                break;
            case R.id.imagePiano:
                MediaPlayer piano = MediaPlayer.create(MainActivity.this, R.raw.piano);
                piano.start();
                break;
            case R.id.imageTabla:
                MediaPlayer tabla = MediaPlayer.create(MainActivity.this, R.raw.tabla);
                tabla.start();
                break;
            case R.id.imageViolin:
                MediaPlayer violin = MediaPlayer.create(MainActivity.this, R.raw.violin);
                violin.start();
                break;
        }
    }
}
