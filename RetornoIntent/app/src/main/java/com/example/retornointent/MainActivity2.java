package com.example.retornointent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText et_nome;
    Button bt_confirmar;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_nome = findViewById(R.id.et_nome);
        bt_confirmar = findViewById(R.id.bt_confirmar);

        i = getIntent();

        et_nome.setText(i.getStringExtra("nome"));

        bt_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("nome", et_nome.getText().toString());
                setResult(2, i);
                finish();
            }
        });
    }


}