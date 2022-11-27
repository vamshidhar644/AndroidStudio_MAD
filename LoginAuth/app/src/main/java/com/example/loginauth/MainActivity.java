package com.example.loginauth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Uname = findViewById(R.id.Uname);
        EditText Pword = findViewById(R.id.Pword);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = Uname.getText().toString();
                String Password = Pword.getText().toString();

                if(Username.equals("abc") && Password.equals("123")){
                    Toast.makeText(MainActivity.this, "Login Successful !", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Failed !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}