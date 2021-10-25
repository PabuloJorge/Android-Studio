package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_nome, et_endereco, et_telefone, et_email, et_genero;
    Button bt_confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nome = findViewById(R.id.et_nome);
        et_endereco = findViewById(R.id.et_endereco);
        et_telefone = findViewById(R.id.et_telefone);
        et_email = findViewById(R.id.et_email);
        et_genero = findViewById(R.id.et_genero);
        bt_confirmar = findViewById(R.id.bt_confirmar);

        bt_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = et_nome.getText().toString().trim().isEmpty() ? "" :
                        et_nome.getText().toString();
                String endereco = et_endereco.getText().toString().trim().isEmpty() ? "" :
                        et_endereco.getText().toString();
                String telefone = et_telefone.getText().toString().trim().isEmpty() ? "" :
                        et_telefone.getText().toString();
                String email = et_email.getText().toString().trim().isEmpty() ? "" :
                        et_email.getText().toString();
                String genero = et_genero.getText().toString().trim().isEmpty() ? "" :
                        et_genero.getText().toString();

                if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || email.isEmpty() || genero.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preenchar todos os camppos",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("nome", nome);
                    i.putExtra("endereco", endereco);
                    i.putExtra("telefone", telefone);
                    i.putExtra("email", email);
                    i.putExtra("genero", genero);
                    startActivity(i);
                }
            }
        });
    }
}