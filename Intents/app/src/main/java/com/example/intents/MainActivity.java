package com.example.intents;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("First Activity");

        EditText name = findViewById(R.id.nameTxt);
        EditText email = findViewById(R.id.emailTxt);
        EditText phone = findViewById(R.id.phoneTxt);
        Button btn = findViewById(R.id.savebtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get data from edit texts
                String nameTxt = name.getText().toString();
                String emailTxt = email.getText().toString();
                String phoneTxt = phone.getText().toString();

                //activity Intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                 intent.putExtra("NAME", nameTxt);
                 intent.putExtra("EMAIL", emailTxt);
                 intent.putExtra("PHONE", phoneTxt);
                 startActivity(intent);
            }
        });
    }
}