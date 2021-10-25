package com.example.conversorhoras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_valorHoras;
    Button bt_converter;
    TextView tv_valorHoras, tv_valorSemanas, tv_valorDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_valorHoras = findViewById(R.id.et_valorHoras);
        bt_converter = findViewById(R.id.bt_converter);
        tv_valorSemanas = findViewById(R.id.tv_valorSemanas);
        tv_valorDias = findViewById(R.id.tv_valorDias);
        tv_valorHoras = findViewById(R.id.tv_valorHoras);

        bt_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valorHoras = et_valorHoras.getText().toString().isEmpty() ? 0 :
                        Integer.parseInt(et_valorHoras.getText().toString());

                int valorSemanas = valorHoras / 168;
                valorHoras = valorHoras - 168 * valorSemanas;
                int valorDias = valorHoras / 24;
                valorHoras = valorHoras % 24;

                tv_valorSemanas.setText(String.valueOf(valorSemanas));
                tv_valorDias.setText(String.valueOf(valorDias));
                tv_valorHoras.setText(String.valueOf(valorHoras));
            }
        });
    }
}