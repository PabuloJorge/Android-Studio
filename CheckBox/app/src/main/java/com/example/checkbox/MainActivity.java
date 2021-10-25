package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    CheckBox cb_agua, cb_cafe, cb_suco;
    Button bt_confirmar;
    EditText et_quantidade_agua, et_quantidade_cafe, et_quantidade_suco;
    double agua = 1.5, cafe = 3, suco = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_agua = findViewById(R.id.cb_agua);
        cb_cafe = findViewById(R.id.cb_cafe);
        cb_suco = findViewById(R.id.cb_suco);

        et_quantidade_agua = findViewById(R.id.et_quantidade_agua);
        et_quantidade_cafe = findViewById(R.id.et_quantidade_cafe);
        et_quantidade_suco = findViewById(R.id.et_quantidade_suco);

        bt_confirmar = findViewById(R.id.bt_confirmar);

        bt_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pedido = "";
                double valor = 0;


                if (cb_agua.isChecked()) {
                    int quantidade = Integer.parseInt(et_quantidade_agua.getText().toString());
                    pedido += quantidade + " Água\n";
                    valor += quantidade * agua;
                }
                if (cb_cafe.isChecked()) {
                    int quantidade = Integer.parseInt(et_quantidade_cafe.getText().toString());
                    pedido += quantidade + " Café\n";
                    valor += quantidade * cafe;
                }
                if (cb_suco.isChecked()) {
                    int quantidade = Integer.parseInt(et_quantidade_suco.getText().toString());
                    pedido += quantidade + " Suco\n";
                    valor += quantidade * suco;
                }

                if (pedido.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Selecione algum item", Toast.LENGTH_SHORT).show();
                } else {
                    DecimalFormat arredondar = new DecimalFormat("#.##");
                    Intent i = new Intent(MainActivity.this, SplashActivity.class);
                    i.putExtra("pedido", pedido + "Total a pagar: R$" + arredondar.format(valor));
                    startActivity(i);
                }
            }
        });

    }
}