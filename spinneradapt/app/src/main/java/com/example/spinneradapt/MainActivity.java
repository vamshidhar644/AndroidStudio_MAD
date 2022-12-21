package com.example.spinneradapt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String countries[]={"Algeria", "Argentina", "Australia", "Brazil", "Cote d'Ivoire", "Cameroon", "India","Chile",
            "Costa Rica", "Denmark", "England", "France", "Germany", "Ghana", "Greece", "Honduras", "Italy", "Japan",
            "Netherlands", "New Zealand", "Nigeria", "North Korea", "Paraguay", "Portugal","Serbia", "Slovakia", "Slovenia",
            "South Africa", "South Korea", "Spain", "Switzerland", "United States", "Uruguay" };

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp=findViewById(R.id.choice);
        sp.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,countries));
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(),text, Toast.LENGTH_LONG).show();
        }
@Override
public void onNothingSelected(AdapterView<?> parent) {
        }
        });
        }
        }
