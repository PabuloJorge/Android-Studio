package com.example.extraintentv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity3 extends AppCompatActivity {
    TextView tv_resultadoSoma, tv_resultadoSub, tv_resultado_Mult, tv_resultadoDiv;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv_resultadoSoma = findViewById(R.id.tv_resultadoSoma);
        tv_resultadoSub = findViewById(R.id.tv_resultadoSub);
        tv_resultado_Mult = findViewById(R.id.tv_resultadoMult);
        tv_resultadoDiv = findViewById(R.id.tv_resultadoDiv);

        i = getIntent();
        double num1 = Double.parseDouble(i.getStringExtra("num1"));
        double num2 = Double.parseDouble(i.getStringExtra("num2"));
        tv_resultadoSoma.setText(num1 + " + " + num2 + " = " + (num1 + num2));
        tv_resultadoSub.setText(num1 + " - " + num2 + " = " + (num1 - num2));
        tv_resultado_Mult.setText(num1 + " * " + num2 + " = " + (num1 * num2));
        DecimalFormat arredondar = new DecimalFormat("#.##");
        tv_resultadoDiv.setText(num1 + " / " + num2 + " = " + arredondar.format((num1 / num2)));


    }
}