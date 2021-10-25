package com.example.sharedpreferencesv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_login, et_senha;
    Button bt_entrar;
    String login, senha;
    CheckBox cb_lembrarAcesso;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_login = findViewById(R.id.et_login);
        et_senha = findViewById(R.id.et_senha);
        bt_entrar = findViewById(R.id.bt_entrar);
        cb_lembrarAcesso = findViewById(R.id.cb_lembrarAcesso);

        sp = getSharedPreferences(getString(R.string.login), Context.MODE_PRIVATE);
        login = sp.getString(getString(R.string.login), "");


        et_login.setText(login);



        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = et_login.getText().toString().trim();
                senha = et_senha.getText().toString().trim();
                
                if (login.isEmpty() || senha.isEmpty()){
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else{
                    if (login.equals("pablo.jorge") && senha.equals("pablodias3")){
                        Toast.makeText(MainActivity.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                        if (cb_lembrarAcesso.isChecked()){
                            editor = sp.edit();
                            editor.putString(getString(R.string.login), login);
                            editor.apply();
                        }
                    } else{
                        Toast.makeText(MainActivity.this, "Login ou senha inválidos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}