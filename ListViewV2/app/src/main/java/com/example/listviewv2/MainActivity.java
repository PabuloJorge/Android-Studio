package com.example.listviewv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_alunos;
    ArrayList<Aluno> alunos;
    ArrayAdapter<Aluno> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_alunos = findViewById(R.id.lv_alunos);

        alunos = new ArrayList<>();

        Aluno a1 = new Aluno("Pablo", "pabulo_dias@hotmail.com", 22);
        Aluno a2 = new Aluno("Pedro", "pedro1_dias1@outlook.com", 21);
        Aluno a3 = new Aluno("Paloma", "paloma3311@gmail.com", 17);
        Aluno a4 = new Aluno("Talia ", "talialife@hotmail.com", 24);

        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a4);

        adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, alunos
        );

        lv_alunos.setAdapter(adapter);

        lv_alunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(MainActivity.this, AlunoActivity.class);
                in.putExtra("nome", alunos.get(i).getNome());
                in.putExtra("email", alunos.get(i).getEmail());
                in.putExtra("idade", alunos.get(i).getIdade());
                startActivity(in);

            }
        });
    }
}