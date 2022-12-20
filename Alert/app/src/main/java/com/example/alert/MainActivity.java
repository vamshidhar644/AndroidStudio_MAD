package com.example.alert;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    EditText e;
    private int[] Time1,Date1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Time1 = new int[2];
        Date1=new int[3];
        e = findViewById(R.id.e);

    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.a:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert");
                builder.setMessage("Do you want to Continue?");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "OK Clicked", Toast.LENGTH_LONG).show();
                    }
                });
                builder.create();
                builder.show();
                return true;


            case R.id.tp:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("Alert");
                builder1.setMessage("Do you want to Open Timepicker?");

                builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        time(Time1, e);
                    }

                    private void time(int[] time1, EditText e) {
                        final Calendar c = Calendar.getInstance();
                        time1[0] = c.get(Calendar.HOUR_OF_DAY);
                        time1[1] = c.get(Calendar.MINUTE);

                        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                e.setText(String.valueOf(hourOfDay + ":" + minute));
                                time1[0] = hourOfDay;
                                time1[1] = minute;
                            }
                        }, time1[0], time1[1], true);
                        timePickerDialog.show();


                    }
                });
                builder1.create();
                builder1.show();
                return true;


            case R.id.dp:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                builder2.setTitle("Alert");
                builder2.setMessage("Do you want to Open Datepicker?");

                builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        date(Date1, e);
                    }

                    private void date(int[] date1, EditText e) {
                        final Calendar c1 = Calendar.getInstance();
                        date1[0] = c1.get(Calendar.YEAR);
                        date1[1] = c1.get(Calendar.MONTH);
                        date1[2] = c1.get(Calendar.DAY_OF_MONTH);

                        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                            @Override

                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                e.setText(String.valueOf(dayOfMonth + "/" + (month + 1) + "/" + year));
                                date1[0] = dayOfMonth;
                                date1[1] = month;
                                date1[2] = year;

                            }
                        }, date1[0], date1[1], date1[2]);
                        datePickerDialog.show();
                    }
                });
                builder2.create();
                builder2.show();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}