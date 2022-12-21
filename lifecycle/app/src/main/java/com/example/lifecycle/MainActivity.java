package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"onCreate Finised",Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onCreate");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart Finised",Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume Finised",Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause Finised",Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop Finised",Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart Finised",Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy Finised",Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onDestroy");
    }
}