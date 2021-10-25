package com.example.listviewv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AlunoActivity extends AppCompatActivity {
    TextView tv_dadosAluno;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        tv_dadosAluno = findViewById(R.id.tv_dadosAluno);

        i = getIntent();

        String nome = i.getStringExtra("nome");
        String email = i.getStringExtra("email");
        int idade = i.getIntExtra("idade", 0);

        tv_dadosAluno.setText("Nome: "+nome+"\n Email: "+email+ "\n Idade: "+idade);



    }
}