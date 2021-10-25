package com.example.formloginv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText et_login, et_senha;
    Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_login = findViewById(R.id.et_login);
        et_senha = findViewById(R.id.et_senha);
        bt_login = findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = et_login.getText().toString().trim();
                String senha = et_senha.getText().toString().trim();

                if (login.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(Login.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = getIntent();
                    if (login.equals(i.getStringExtra("login"))
                            && senha.equals(i.getStringExtra("senha"))) {
                        i = new Intent(Login.this, MainActivity.class);
                        startActivity(i);
                    } else{
                        Toast.makeText(Login.this, "Login ou senha inválidos", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
}