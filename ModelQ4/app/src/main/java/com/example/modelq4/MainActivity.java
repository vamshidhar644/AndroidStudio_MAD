package com.example.modelq4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        gotoUrl("https://vitap.ac.in/");
    }
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }
    protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        finish();
    }
    private void gotoUrl(String u)
    {
        Uri uri=Uri.parse(u);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}