package com.example.playcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    EditText c1,c2,c3,c4,c5;
    Button b3;
    String temp;
    int sum = 0;
    String[] sortedCards = new String[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras = getIntent().getExtras();
        c1 = findViewById(R.id.edittext11);
        c2 = findViewById(R.id.edittext12);
        c3 = findViewById(R.id.edittext13);
        c4 = findViewById(R.id.edittext14);
        c5 = findViewById(R.id.edittext15);
        b3 = findViewById(R.id.button11);
        String card1 = extras.getString("Card1");
        String card2 = extras.getString("Card2");
        String card3 = extras.getString("Card3");
        String card4 = extras.getString("Card4");
        String card5 = extras.getString("Card5");
        sortedCards[0] = card1;
        sortedCards[1] = card2;
        sortedCards[2] = card3;
        sortedCards[3] = card4;
        sortedCards[4] = card5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (Integer.parseInt(sortedCards[i]) <
                        Integer.parseInt(sortedCards[j])) {
                    temp = sortedCards[i];
                    sortedCards[i] = sortedCards[j];
                    sortedCards[j] = temp;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            sum += Integer.parseInt(sortedCards[i]);
        }
        c1.setText(sortedCards[0]);
        c2.setText(sortedCards[1]);
        c3.setText(sortedCards[2]);
        c4.setText(sortedCards[3]);
        c5.setText(sortedCards[4]);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                i.putExtra("c1", sortedCards[0]);
                i.putExtra("c2", sortedCards[1]);
                i.putExtra("c3", sortedCards[2]);
                i.putExtra("c4", sortedCards[3]);
                i.putExtra("c5", sortedCards[4]);
                i.putExtra("sum", String.valueOf(sum));
                setResult(RESULT_OK, i);
                finish()
                ;

            }
        });
    }
}