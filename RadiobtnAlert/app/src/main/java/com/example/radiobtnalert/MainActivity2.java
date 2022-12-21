package com.example.radiobtnalert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       TextView tv1=(TextView)findViewById(R.id.tv1);

        Intent i=getIntent();
        tv1.setText(i.getStringExtra("msg"));
        tv1.setText(i.getStringExtra("msg"));
        tv1.setText(i.getStringExtra("msg"));
        tv1.setText(i.getStringExtra("msg"));



    }
}