package com.example.formloginv2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    Button bt_menu_login, bt_menu_registrar, bt_menu_sobre;
    String login = "", senha = "";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2 && data != null) {

            login = data.getStringExtra("login");
            senha = data.getStringExtra("senha");
            Toast.makeText(Menu.this, "Dados de login atualizados", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bt_menu_login = findViewById(R.id.bt_menu_login);
        bt_menu_registrar = findViewById(R.id.bt_menu_registrar);
        bt_menu_sobre = findViewById(R.id.bt_menu_sobre);

        bt_menu_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(Menu.this, "Nenhum usuário registrado", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(Menu.this, Login.class);
                    i.putExtra("login", login);
                    i.putExtra("senha", senha);
                    startActivity(i);
                }

            }
        });

        bt_menu_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Registrar.class);
                startActivityForResult(i, 1);
            }
        });

        bt_menu_sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Sobre.class);
                startActivity(i);
            }
        });


    }
}