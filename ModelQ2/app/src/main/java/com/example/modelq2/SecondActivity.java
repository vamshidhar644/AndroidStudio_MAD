package com.example.modelq2;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv1=(TextView)findViewById(R.id.textView1);

        Bundle extras=getIntent().getExtras();
        String a="";
        if(extras!=null)
        {
            a=extras.getString("a");
        }
        tv1.setText(a);
    }

}