package com.example.m1q1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CheckBox c1;
    MediaPlayer mp1;
    Switch s1;
    ToggleButton t1;
    Button sendbroadcast;
    WifiManager wifiManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp1 = MediaPlayer.create(this,R.raw.test4);
        c1=findViewById(R.id.ch1);
        s1=findViewById(R.id.sw);
        t1=findViewById(R.id.tg);
        sendbroadcast=findViewById(R.id.b1);
        wifiManager=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(c1.isChecked()==true)
                {
                    mp1.start();
                }
                else
                {
                    mp1.stop();
                }

            }
        });

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(s1.isChecked()==true) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://google.com/"));
                    startActivity(intent);
                }
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t1.isChecked()==true)
                {
                    Intent i=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(i);
                }
            }
        });

        sendbroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wifiManager.isWifiEnabled())
                {
                    Toast.makeText(MainActivity.this, "WIFI ON", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "WIFI OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private  BroadcastReceiver wifireceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifistate=intent.getIntExtra(wifiManager.EXTRA_WIFI_STATE, wifiManager.WIFI_STATE_UNKNOWN);
            switch (wifistate)
            {

                case WifiManager.WIFI_STATE_ENABLED:
                    Toast.makeText(MainActivity.this, "WIFI ON", Toast.LENGTH_SHORT).show();
                    break;

                case WifiManager.WIFI_STATE_DISABLED:
                    Toast.makeText(MainActivity.this, "WIFI OFF", Toast.LENGTH_SHORT).show();
                    break;

            }

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(wifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifireceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifireceiver);
    }
}