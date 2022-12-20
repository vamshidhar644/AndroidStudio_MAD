package com.example.iotstore;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView tvAmountDisplayer;
    private EditText etAurdino, etWifi, etBluetooth;
    private Button btSubmit, btClear;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAmountDisplayer=findViewById(R.id.tvAmountDisplayer);
        etAurdino=findViewById(R.id.etAurdino);
        etWifi=findViewById(R.id.etWifi);
        etBluetooth=findViewById(R.id.etbluetooth);
        btSubmit=findViewById(R.id.btSubmit);
        btClear=findViewById(R.id.btClear);
        btClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                etAurdino.setText(null);
                etWifi.setText(null);
                etBluetooth.setText(null);
                tvAmountDisplayer.setText(null);
            }
        });
        btSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int amount=0;
                StringBuilder result=new StringBuilder();
                String s1=etAurdino.getText().toString();
                String s2=etWifi.getText().toString();
                String s3=etBluetooth.getText().toString();
                double s11=Integer.parseInt(s1);
                double s22=Integer.parseInt(s2);
                double s33=Integer.parseInt(s3);
                if(etAurdino.isEnabled())
                {
                    amount+=s11*500;
                }
                if(etWifi.isEnabled())
                {
                    amount+=s22*250;
                }
                if(etBluetooth.isEnabled())
                {
                    amount+=s33*200;
                }
                result.append(amount);
                String answer=result.toString();
                tvAmountDisplayer.setText(answer);
            }
        });
    }
}
