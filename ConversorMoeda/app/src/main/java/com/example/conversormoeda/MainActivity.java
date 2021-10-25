package com.example.conversormoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText et_valorEuros;
    Button bt_converter;
    TextView tv_valorDolares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_valorEuros = findViewById(R.id.et_valorEuros);
        bt_converter = findViewById(R.id.bt_converter);
        tv_valorDolares = findViewById(R.id.tv_valorDolares);

        bt_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valorEuros = Double.parseDouble(et_valorEuros.getText().toString());

                DecimalFormat arredondar = new DecimalFormat("#.##");
                double valorDolares = Double.parseDouble(arredondar.format(valorEuros * 0.90));

                tv_valorDolares.setText(String.valueOf(valorDolares  + "$"));
            }
        });


    }
}