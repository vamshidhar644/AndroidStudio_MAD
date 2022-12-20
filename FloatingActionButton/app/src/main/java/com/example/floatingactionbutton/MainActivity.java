package com.example.floatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle; import android.view.View;
import android.view.animation.Animation; import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final boolean[] flag = {false};
        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        final FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        final FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fab3);

        final FloatingActionButton fab4 = (FloatingActionButton) findViewById(R.id.fab4);

        final Animation in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.show);
        final Animation out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.hide);

        fab2.setVisibility(View.GONE);
        fab3.setVisibility(View.GONE);
        fab4.setVisibility(View.GONE);


        fab1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                        if (!flag[0]) {
                            Toast.makeText(getApplicationContext(), "fba1",
                                    Toast.LENGTH_SHORT).show();
                            fab2.startAnimation(in);
                            fab3.startAnimation(in);
                            fab4.startAnimation(in);
                            fab2.setVisibility(View.VISIBLE);
                            fab3.setVisibility(View.VISIBLE);
                            fab4.setVisibility(View.VISIBLE);
                            flag[0]=!flag[0];
                        } else {
                            fab2.startAnimation(out);
                            fab3.startAnimation(out);
                            fab4.startAnimation(out);
                            fab2.setVisibility(View.GONE);
                            fab3.setVisibility(View.GONE);
                            fab4.setVisibility(View.GONE);

                            flag[0] = flag[0];
                        }
                    }
                });


                fab2.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "fba2", Toast.LENGTH_SHORT).show();
        }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "fba3", Toast.LENGTH_SHORT).show();
        }
        });

        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "fba4", Toast.LENGTH_SHORT).show();
        }
        });
    }
}
