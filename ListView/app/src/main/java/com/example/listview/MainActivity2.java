package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView t1,t2;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.textView2);
        t2=findViewById(R.id.textView3);
        imageview=findViewById(R.id.imageView2);
        Intent i=getIntent();
        t1.setText(i.getStringExtra("name"));
        t2.setText(i.getStringExtra("desc"));
        imageview.setImageResource(i.getIntExtra("image",0));
    }
}