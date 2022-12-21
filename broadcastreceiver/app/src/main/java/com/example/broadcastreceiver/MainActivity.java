package com.example.broadcastreceiver;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent; import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity { @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    MyReceiver r = new MyReceiver();
    IntentFilter filter = new IntentFilter();
    filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
    filter.addAction(Intent.ACTION_HEADSET_PLUG);
    filter.addAction(Intent.ACTION_POWER_CONNECTED);
    filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
    filter.addAction(Intent.ACTION_DATE_CHANGED);
    this.registerReceiver(r, filter);

}	}
