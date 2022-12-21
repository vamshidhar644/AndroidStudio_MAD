package com.example.dialogdatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int[] Date1 ,Date2, Date3;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et1=(EditText)findViewById(R.id.ETD1);
        final EditText et2=(EditText)findViewById(R.id.ETD2);
        final EditText et3=(EditText)findViewById(R.id.ETD3);

        Button b2=(Button)findViewById(R.id.DB1);
        Button b3=(Button)findViewById(R.id.DB2);
        Button b4=(Button)findViewById(R.id.DB3);


        Date1=new int [3];
        Date2=new int [3];
        Date3=new int [3];

        b2.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            date(Date1, et1);
        }
        });

        b3.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            date(Date2,et2);
        }
        });

        b4.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            date(Date3,et3);
        }
        });

    }

    void date(final int[]d, final EditText e)
    {
        final Calendar c1 = Calendar.getInstance();
        d[0] = c1.get(Calendar.YEAR);
        d[1] = c1.get(Calendar.MONTH);
        d[2] = c1.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override

            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                e.setText(String.valueOf(dayOfMonth+"/"+(month+1)+"/"+year)); d[0]=dayOfMonth;
                d[1]=month;
                d[2]=year;

            }
        },d[0],d[1],d[2]);
        datePickerDialog.show();

    }
}