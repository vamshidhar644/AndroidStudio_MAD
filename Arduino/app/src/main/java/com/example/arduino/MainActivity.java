package com.example.arduino;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    final EditText e1 =(EditText)findViewById(R.id.et1);

    final EditText e2 =(EditText)findViewById(R.id.et2);
    final EditText e3 =(EditText)findViewById(R.id.et3);
    final EditText e4 =(EditText)findViewById(R.id.et4);
    final EditText e5 =(EditText)findViewById(R.id.et5);
    final EditText e6 =(EditText)findViewById(R.id.et6);
    final EditText e7 =(EditText)findViewById(R.id.et7);
    final EditText e8 =(EditText)findViewById(R.id.et8);

    Button b1=(Button)findViewById(R.id.b1);
    b1.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            e6.setText(String.valueOf(Double.parseDouble(e1.getText().toString())*500));
            e7.setText(String.valueOf(Double.parseDouble(e2.getText().toString())*200));
            e8.setText(String.valueOf(Double.parseDouble(e3.getText().toString())*100));


            e4.setText( String.valueOf(
                    Double.parseDouble(e1.getText().toString())+ Double.parseDouble(e2.getText().toString())+ Double.parseDouble(e3.getText().toString()))

            );

            e8.setText( String.valueOf(
                    Double.parseDouble(e5.getText().toString())+ Double.parseDouble(e6.getText().toString())+ Double.parseDouble(e7.getText().toString()))

            );
        }
    });
}
}