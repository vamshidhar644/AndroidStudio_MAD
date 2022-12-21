package com.example.q3menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel("p","priya", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.one){
            Intent i = new Intent(getApplicationContext(), AddNow.class);
            startActivity(i);

        }
        if(item.getItemId()==R.id.two){
            Intent i = new Intent(getApplicationContext(), Callback.class);
            startActivity(i);

        }
        if(item.getItemId()==R.id.three){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);


            builder.setTitle("Alert!!");
            builder.setMessage("Camera Not available");
            AlertDialog alertDialog = builder.create();

            alertDialog.show();
        }
        if(item.getItemId()==R.id.four){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "p");
            builder.setSmallIcon(R.drawable.ic_launcher_foreground);
            builder.setContentTitle("Cart is full");
            Notification notification= builder.build();
            NotificationManagerCompat manager = NotificationManagerCompat.from(MainActivity.this);
            manager.notify(1,notification);

        }
        return super.onOptionsItemSelected(item);
    }
}