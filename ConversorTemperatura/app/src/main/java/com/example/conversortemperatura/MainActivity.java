package com.example.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText et_temperaturaC;
    Button bt_converter;
    TextView tv_temperaturaF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temperaturaC = findViewById(R.id.et_temperaturaC);
        bt_converter = findViewById(R.id.bt_converter);
        tv_temperaturaF = findViewById(R.id.tv_temperatucaF);

        bt_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double temperaturaC = Double.parseDouble(et_temperaturaC.getText().toString());
                DecimalFormat arredondar = new DecimalFormat("#.##");
                double temperaturaF = Double.parseDouble(arredondar.format(temperaturaC * 1.8 + 32));
                tv_temperaturaF.setText(String.valueOf(temperaturaF));
            }
        });



    }
}