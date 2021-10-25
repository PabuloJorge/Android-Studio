package com.example.conversormoedav4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    EditText et_valorEuros;
    Button bt_converterDolar, bt_converterReal, bt_converterPeso;
    TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_valorEuros = findViewById(R.id.et_valorEuros);
        bt_converterDolar = findViewById(R.id.bt_converterDolar);
        bt_converterPeso = findViewById(R.id.bt_converterPeso);
        bt_converterReal = findViewById(R.id.bt_converterReal);
        tv_resultado = findViewById(R.id.tv_resultado);

        bt_converterDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double valorEuros = et_valorEuros.getText().toString().isEmpty() ? 0 :
                        Double.parseDouble(et_valorEuros.getText().toString());
                if (valorEuros > 0) {
                    DecimalFormat arredondar = new DecimalFormat("#.##");
                    double valorDolares = Double.parseDouble(arredondar.format(valorEuros * 1.5));
                    tv_resultado.setText(String.valueOf(valorDolares+"$"));
                } else {
                    Toast.makeText(MainActivity.this, "Digite um valor maior que 0",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

        bt_converterPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double valorEuros = et_valorEuros.getText().toString().isEmpty() ? 0 :
                        Double.parseDouble(et_valorEuros.getText().toString());
                if (valorEuros > 0) {
                    DecimalFormat arredondar = new DecimalFormat("#.##");
                    double valorPesos = Double.parseDouble(arredondar.format(valorEuros * 2));
                    tv_resultado.setText(String.valueOf(valorPesos+"$"));
                } else {
                    Toast.makeText(MainActivity.this, "Digite um valor maior que 0",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

        bt_converterReal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double valorEuros = et_valorEuros.getText().toString().isEmpty() ? 0 :
                        Double.parseDouble(et_valorEuros.getText().toString());
                if (valorEuros > 0) {
                    DecimalFormat arredondar = new DecimalFormat("#.##");
                    double valorReal = Double.parseDouble(arredondar.format(valorEuros * 3));
                    tv_resultado.setText(String.valueOf("R$"+valorReal));
                } else {
                    Toast.makeText(MainActivity.this, "Digite um valor maior que 0",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}