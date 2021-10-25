package com.example.parprimo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_numero;
    Button bt_verificar;
    TextView tv_resultadoPrimo, tv_resultadoPar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_numero = findViewById(R.id.et_numero);
        bt_verificar = findViewById(R.id.bt_verificar);
        tv_resultadoPrimo = findViewById(R.id.tv_resultadoPrimo);
        tv_resultadoPar = findViewById(R.id.tv_resultadoPar);

        bt_verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numero = et_numero.getText().toString().isEmpty() ? 0 :
                        Integer.parseInt(et_numero.getText().toString());
                if (numero == 0) {
                    Toast.makeText(MainActivity.this, "Digite um valor maior que 0",
                            Toast.LENGTH_SHORT).show();
                } else {
                    //Verificando se o número é par ou ímpar
                    if (numero % 2 == 0) {
                        tv_resultadoPar.setText("Número PAR");
                    } else {
                        tv_resultadoPar.setText("Número ÍMPAR");
                    }
                    //Verificando se o número é primo
                    int res=0;
                    for (int i=2; i < numero;i++){
                        if (numero % i ==0){
                            res++;
                        }
                    }
                    if (res > 0 || numero == 1){
                        tv_resultadoPrimo.setText("Número NÃO é PRIMO");
                    } else{
                        tv_resultadoPrimo.setText("Número é PRIMO");
                    }
                }
            }
        });


    }
}