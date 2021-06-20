package com.sefayilmaz.akinonvakacozum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(fibonacci(Integer.parseInt(editText.getText().toString())));

                int number = Integer.parseInt(editText.getText().toString());
                textView1.setText("" + String.format(Locale.getDefault(), "%.0f", factoriyel(number)));
            }
        });
    }

    private String fibonacci(int n) {

        String text = " ";
        ArrayList<BigInteger> fibo = new ArrayList<>();
        BigInteger first = new BigInteger("0");
        BigInteger second = new BigInteger("1");
        fibo.add(first);
        fibo.add(second);

        for (int i = 1; i < n; i++) {
            fibo.add(fibo.get(i).add(fibo.get(i - 1)));
        }
        for (int i = 1; i <= n; i++) {
            text = text + i + " --> " + fibo.get(i) + "\n";
        }
        return text;

    }

    public double factoriyel (double number) {
        if (number < 2){
            return 1;
        }else {
            return number * factoriyel(number-1);

        }

    }

}