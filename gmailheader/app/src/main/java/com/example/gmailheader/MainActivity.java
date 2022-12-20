package com.example.gmailheader;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1,e2,e3,e4;
    private ChipGroup c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b);
        e1 = findViewById(R.id.from);
        e2 = findViewById(R.id.to);
        e3 = findViewById(R.id.msg);
        e4 = findViewById(R.id.subject);
        c = findViewById(R.id.chipgr);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chip chip = new Chip(MainActivity.this);
                c.addView(chip);
                chip.setText(e2.getText());
                chip.setChipIcon(getDrawable(R.drawable.round));
                e2.setText(null);
                chip.setCloseIconVisible(true);

                chip.setOnCloseIconClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        c.removeView(chip);
                    }
                });

            }
        });
    }
}