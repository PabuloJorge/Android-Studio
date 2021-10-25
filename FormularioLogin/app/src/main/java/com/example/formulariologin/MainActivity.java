package com.example.formulariologin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_login, et_senha;
    Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_login = findViewById(R.id.et_login);
        et_senha = findViewById(R.id.et_senha);
        bt_login = findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = et_login.getText().toString();
                String senha = et_senha.getText().toString();
                if (login.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos",
                            Toast.LENGTH_SHORT).show();
                } else {
                    if (login.trim().equals("pablo.jorge") && senha.trim().equals("pablodias3")) {
                        Toast.makeText(MainActivity.this, "Login efetuado com sucesso",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Falha no login", Toast.LENGTH_SHORT).show();
                    }
                }

                et_login.setText("");
                et_senha.setText("");
            }
        });
    }
}