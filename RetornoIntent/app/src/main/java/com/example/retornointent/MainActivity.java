package com.example.retornointent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_nome;
    Button bt_mudarNome;
    String nome = "Usuário";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_nome = findViewById(R.id.tv_nome);
        bt_mudarNome = findViewById(R.id.bt_mudarNome);

        tv_nome.setText("Olá, "+nome);

        bt_mudarNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("nome", nome);
                startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 2 && data != null){
            nome = data.getStringExtra("nome");
            tv_nome.setText("Olá, "+nome);
        }
    }
}