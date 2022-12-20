package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener  {
    EditText e1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.time1);
        b1 = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimepickerFragment timepickerFragment = new TimepickerFragment();
                timepickerFragment.show(getSupportFragmentManager(),"Time Picker");
            }
        });
    }
    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute){
        e1.setText(String.valueOf(hourOfDay)+":"+String.valueOf(minute));
    }
}
