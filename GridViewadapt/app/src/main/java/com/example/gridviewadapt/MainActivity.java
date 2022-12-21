package com.example.gridviewadapt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gd=findViewById(R.id.grid1);
        gd.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries));
    }
    String countries[]={"Algeria", "Argentina", "Australia", "Brazil", "Cote d'Ivoire", "Cameroon", "India","Chile",
            "Costa Rica", "Denmark", "England", "France", "Germany", "Ghana", "Greece", "Honduras", "Italy", "Japan",
            "Netherlands", "New Zealand", "Nigeria", "North Korea", "Paraguay", "Portugal","Serbia", "Slovakia", "Slovenia",
            "South Africa", "South Korea", "Spain", "Switzerland", "United States", "Uruguay" };
        }
