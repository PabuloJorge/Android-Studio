package com.example.ola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_nome;
    EditText et_sobrenome;
    Button bt_confirmar;
    TextView tv_ola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nome = findViewById(R.id.et_nome);
        et_sobrenome = findViewById(R.id.et_sobrenome);
        bt_confirmar = findViewById(R.id.bt_confirmar);
        tv_ola = findViewById(R.id.tv_ola);

        bt_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = et_nome.getText().toString();
                String sobrenome = et_sobrenome.getText().toString();

                if (nome.isEmpty() || sobrenome.isEmpty()){
                    Toast.makeText(MainActivity.this,"Preencha todos os campos",Toast.LENGTH_LONG).show();
                } else{
                    tv_ola.setText("Olá, "+nome+" "+sobrenome);
                }

            }
        });


    }
}