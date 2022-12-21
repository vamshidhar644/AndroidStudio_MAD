package com.example.externalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button save,read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        save=findViewById(R.id.button);
        read=findViewById(R.id.button2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String state = Environment.getExternalStorageState();
                if (Environment.MEDIA_MOUNTED.equals(state)) {
                    File dir = new File(Environment.getExternalStorageDirectory() + "/sdcard");
                    if(!dir.exists()){
                        dir.mkdir();
                    }
                    File myfile = new File(dir, ed1.getText().toString());
                    try {
                        FileOutputStream fos = new FileOutputStream(myfile);
                        String content = ed2.getText().toString();
                        fos.write(content.getBytes());


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getApplicationContext(), "file save at " + myfile.getName(), Toast.LENGTH_LONG).show();
                    ed2.setText(" ");

                }
            }

        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File dir = new File(Environment.getExternalStorageDirectory() + "/sdcard");
                File myfile = new File(dir, ed1.getText().toString());
                try {
                    FileInputStream fis = new FileInputStream(myfile);
                    InputStreamReader isr=new InputStreamReader(fis);
                    BufferedReader br=new BufferedReader(isr);
                    StringBuilder sb=new StringBuilder();
                    String text;
                    while((text=br.readLine())!=null){
                        sb.append(text.toString());
                    }
                    ed2.setText(sb);
                }
                catch(FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }

            }
        });
}
}