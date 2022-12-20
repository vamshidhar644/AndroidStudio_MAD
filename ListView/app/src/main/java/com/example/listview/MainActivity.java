package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.stream.BaseStream;

public class MainActivity extends AppCompatActivity {
String names[]={"Bike","Boat","Bus","Car","Train","Walk"};
String desc[]={"Time to Travel: 5hrs 6 min","Time to Travel: 10hrs 6 min","Time to Travel: 5hrs 10 min","Time to Travel: 4hrs 57 min","Time to Travel: 8hrs 6 min","Time to Travel: 55hrs 3 min"};
int images[]={R.drawable.bike,R.drawable.boat,R.drawable.bus,R.drawable.car,R.drawable.train,R.drawable.run};
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lsv);
        lv.setAdapter(new MyAdapter(this));
    }


    private class MyAdapter extends BaseAdapter {
        Context context;
        public MyAdapter(MainActivity mainActivity) {
            context=mainActivity;
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
           View V= LayoutInflater.from(context).inflate(R.layout.layout,viewGroup,false);
            TextView t1=V.findViewById(R.id.textView);
            ImageView img=V.findViewById(R.id.imageView);
            t1.setText(names[i]);
            img.setImageResource(images[i]);
            V.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(getApplicationContext(),MainActivity2.class);
                    intent.putExtra("name",names[i]);
                    intent.putExtra("desc",desc[i]);
                    intent.putExtra("image",images[i]);
                    startActivity(intent);
                }
            });
            return V;
        }
    }
}