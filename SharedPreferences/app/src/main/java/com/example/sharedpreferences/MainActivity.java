package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText et_valor;
    TextView tv_valor;
    Button bt_ok;
    SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_valor = findViewById(R.id.et_valor);
        tv_valor = findViewById(R.id.tv_valor);
        bt_ok = findViewById(R.id.bt_ok);

        sp = getSharedPreferences(getString(R.string.key), Context.MODE_PRIVATE);
        String resultado = sp.getString(getString(R.string.key), "");
        tv_valor.setText("Valor: " + resultado);

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor = sp.edit();
                editor.putString(getString(R.string.key), et_valor.getText().toString());
                editor.apply();
                String resultado = sp.getString(getString(R.string.key), "");
                tv_valor.setText("Valor: " + resultado);
                et_valor.setText("");
            }
        });
    }
}