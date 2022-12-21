package com.example.autotextviewadapt;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView t1 = (AutoCompleteTextView) findViewById(R.id.editText);
        t1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, countries));
    }

    String countries[] = {"Algeria", "Argentina", "Australia", "Brazil", "Cote d'Ivoire", "Cameroon", "India", "Chile", "Costa Rica", "Denmark", "England", "France", "Germany", "Ghana", "Greece", "Honduras", "Italy", "Japan", "Netherlands", "New Zealand", "Nigeria", "North Korea", "Paraguay", "Portugal", "Serbia", "Slovakia", "Slovenia", "South Africa", "South Korea", "Spain", "Switzerland", "United States", "Uruguay"};
}

