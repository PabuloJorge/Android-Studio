package com.example.formloginv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    EditText et_registrar_login, et_registrar_senha;
    Button bt_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        et_registrar_login = findViewById(R.id.et_registrar_login);
        et_registrar_senha = findViewById(R.id.et_registrar_senha);
        bt_registrar = findViewById(R.id.bt_registrar);

        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_registrar_login.getText().toString().trim().isEmpty()
                        || et_registrar_senha.getText().toString().trim().isEmpty()){
                    Toast.makeText(Registrar.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else{
                    Intent i = getIntent();
                    i.putExtra("login", et_registrar_login.getText().toString());
                    i.putExtra("senha", et_registrar_senha.getText().toString());
                    setResult(2, i);
                    finish();

                }
            }
        });
    }
}