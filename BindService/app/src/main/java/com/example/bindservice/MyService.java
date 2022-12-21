package com.example.bindservice;

import static android.content.ContentValues.TAG;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    int a;
    public MyService() {
    }
    MyBinder myBinder=new MyBinder();


    class MyBinder extends Binder {
        public MyService getService()
        {
            Log.d(TAG, "getService: ");
            return MyService.this;
        }
    }

    @Override
    public void onCreate() {
        Toast.makeText(this,"onCreate Finised",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this,"onBind Finised",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onBind: ");
        return myBinder;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this,"onUnbind Finised",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this,"onDestory Finised",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
    public int count()
    {
        a++;
        return a;
    }
}