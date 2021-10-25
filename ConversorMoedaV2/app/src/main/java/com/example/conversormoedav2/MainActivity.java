package com.example.conversormoedav2;

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
    TextView tv_valorReal ;
    TextView tv_valorDolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         et_valorEuros = findViewById(R.id.et_valorEuros);
         bt_converter = findViewById(R.id.bt_conventer);
         tv_valorReal = findViewById(R.id.tv_valorReal);
         tv_valorDolar = findViewById(R.id.tv_valorDolar);

        bt_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valorEuros = Double.parseDouble(et_valorEuros.getText().toString());
                DecimalFormat arredondar = new DecimalFormat("#.##");
                double valorReal = Double.parseDouble(arredondar.format(valorEuros * 1.50));
                double valorDolar = Double.parseDouble(arredondar.format(valorEuros * 2));

                tv_valorReal.setText(String.valueOf(valorReal));
                tv_valorDolar.setText(String.valueOf(valorDolar));

            }
        });
    }
}