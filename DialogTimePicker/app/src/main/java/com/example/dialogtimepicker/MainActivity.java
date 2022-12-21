package com.example.dialogtimepicker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int[] Time1,Time2,Time3;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et4 = (EditText) findViewById(R.id.ETT1);
        final EditText et5 = (EditText) findViewById(R.id.ETT2);
        final EditText et6 = (EditText) findViewById(R.id.ETT3);
        Button b2 = (Button) findViewById(R.id.TB1);
        Button b3 = (Button) findViewById(R.id.TB2);
        Button b4 = (Button) findViewById(R.id.TB3);

        Time1 = new int[2];
        Time2 = new int[2];
        Time3 = new int[2];


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time(Time1, et4);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time(Time2, et5);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time(Time3, et6);
            }
        });

    }

    void time(final int[] t, final EditText e)

    {

        final Calendar c = Calendar.getInstance(); t[0] = c.get(Calendar.HOUR_OF_DAY);
        t[1] = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                e.setText(String.valueOf(hourOfDay + ":" + minute));
                t[0] = hourOfDay;
                t[1] = minute;
            }
        }, t[0], t[1], true); timePickerDialog.show();
    }
}