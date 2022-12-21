package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String countries[] = {"Algeria", "Argentina", "Austin", "Australia", "Brazil", "Cote d'Ivoire", "Cameroon",

            "Chile", "Costa Rica", "Denmark", "England", "France", "Germany", "Ghana", "Greece", "Honduras", "Italy", "Japan", "Netherlands",
            "New Zealand", "Nigeria", "North Korea", "Paraguay", "Portugal", "Serbia", "Slovakia", "Slovenia", "South Africa", "South Korea",
            "Spain", "Switzerland", "United States", "Uruguay"};

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler);
     recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter=new MyAdapter(this,countries);
        recyclerView.setAdapter(myAdapter);
        }

        }
class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> {
    Context mycontext;
    String mycountries[];
    public MyAdapter(Context context,String countires[] ) {
        mycontext=context;
        mycountries=countires;
    }
    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mycontext);
        View v=layoutInflater.inflate(R.layout.my_text_view,parent,false);
        return new Myholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.textView.setText(mycountries[position]);
    }
    @Override
    public int getItemCount() {
        return mycountries.length;
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView textView;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview1);

        }
    }
}
