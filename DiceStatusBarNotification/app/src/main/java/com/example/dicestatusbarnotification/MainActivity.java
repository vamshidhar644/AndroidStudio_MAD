package com.example.dicestatusbarnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder builder;
    NotificationManagerCompat manager;
    Button b1,b2,b3;
    EditText ed1,ed2;
    String channelid = "winner";
    int NOTIFICATION_ID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        final Random myRandom=new Random();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(String.valueOf(myRandom.nextInt(6)));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed2.setText(String.valueOf(myRandom.nextInt(6)));
            }
        });

        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel=new NotificationChannel(channelid,"Priya", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(ed1.getText().toString());
                int b=Integer.parseInt(ed2.getText().toString());

                builder=new NotificationCompat.Builder(MainActivity.this,channelid);
                builder.setSmallIcon(R.drawable.ic_launcher_foreground);
                builder.setContentTitle("Winner:");

                if (a>b){

                    builder.setContentText("winner is user-1");
                }
                else if(a==b){
                    builder.setContentText("Tie between two users");
                }
                else{
                    builder.setContentText("winner is user-2");
                }
                Notification notification= builder.build();
                manager=NotificationManagerCompat.from(MainActivity.this);
                manager.notify(NOTIFICATION_ID,notification);

            }
        });
    }
}