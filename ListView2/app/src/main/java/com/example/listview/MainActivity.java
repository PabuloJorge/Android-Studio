package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_numeros;
    EditText et_numero;
    Button bt_adicionar;
    ArrayList<Integer> numeros;
    ArrayAdapter<Integer> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_numeros = findViewById(R.id.lv_numeros);
        et_numero = findViewById(R.id.et_numero);
        bt_adicionar = findViewById(R.id.bt_adicionar);

        numeros = new ArrayList<>();


        adapter = new ArrayAdapter(
                MainActivity.this, android.R.layout.simple_list_item_1, numeros
        );

        lv_numeros.setAdapter(adapter);

        bt_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numero = et_numero.getText().toString().isEmpty() ? 0 :
                        Integer.parseInt(et_numero.getText().toString());
                if (numero == 0) {
                    Toast.makeText(MainActivity.this, "Digite um valor maior que 0",
                            Toast.LENGTH_SHORT).show();
                } else {
                    numeros.add(numero);
                    adapter.notifyDataSetChanged();
                    et_numero.setText("");
                }
            }
        });


    }
}