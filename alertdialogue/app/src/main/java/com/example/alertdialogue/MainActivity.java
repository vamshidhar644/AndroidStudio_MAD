package com.example.alertdialogue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setIcon(R.drawable.ic_layer);
                builder.setTitle("Prompt user input");
                builder.setMessage("Please type a message.");
                final EditText input = new EditText(MainActivity.this);
                builder.setView(input);



                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("AlertDialog","input text =" + input.getText().toString());
                        Toast.makeText(getApplicationContext(),"Msg is "+ input.getText().toString(), Toast.LENGTH_LONG).show();

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {  @Override
                public void onClick(DialogInterface dialog, int which) {

                }
                });
                builder.create().show();

            }
        });
    }
}
