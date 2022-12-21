package com.example.modelq2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    RadioGroup rg1;
    RadioButton r1, r2, r3, r4;
    int n, i, flag = 0, temp;
    Button b1;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button b1 = (Button) findViewById(R.id.btVerify);
        et1 = (EditText) findViewById(R.id.etInput);
        rg1 = (RadioGroup) findViewById(R.id.rg);
        r1 = (RadioButton) findViewById(R.id.rbPrime);
        r2 = (RadioButton) findViewById(R.id.rbEven);
        r3 = (RadioButton) findViewById(R.id.rbEvenDigits);


        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                n = Integer.parseInt(et1.getText().toString());

                int id = rg1.getCheckedRadioButtonId();

                if (id == R.id.rbPrime) {
                    for (i = 2; i < n; i++) {
                        if (n % i == 0) {
                            flag = 1;
                            break;
                        } else {
                            flag = 0;
                        }
                    }
                    if (flag == 0) {
                        a = "Prime";
                    } else {
                        a = "Not Prime";
                    }

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("a", a);
                    startActivity(intent);
                } else if (id == R.id.rbEven) {
                    if (n % 2 == 0) {
                        a = "Even";
                    } else {
                        a = "Odd";
                    }

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("a", a);
                    startActivity(intent);
                } else if (id == R.id.rbEvenDigits) {
                    temp = n;
                    int count = 0;
                    while (temp != 0) {
                        count++;
                        temp /= 10;
                    }
                    if (count % 2 == 0) {
                        a = "Even number of digits";
                    } else {
                        a = "Odd number of digits";
                    }

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("a", a);
                    startActivity(intent);
                }
            }

        });
    }
}

