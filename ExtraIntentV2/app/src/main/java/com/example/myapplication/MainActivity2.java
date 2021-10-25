package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tv_nome, tv_endereco, tv_telefone, tv_email, tv_genero;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_nome = findViewById(R.id.tv_nome);
        tv_endereco = findViewById(R.id.tv_endereco);
        tv_telefone = findViewById(R.id.tv_telefone);
        tv_email = findViewById(R.id.tv_email);
        tv_genero = findViewById(R.id.tv_genero);

        i = getIntent();

        tv_nome.setText(i.getStringExtra("nome"));
        tv_endereco.setText(i.getStringExtra("endereco"));
        tv_telefone.setText(i.getStringExtra("telefone"));
        tv_email.setText(i.getStringExtra("email"));
        tv_genero.setText(i.getStringExtra("genero"));


    }
}