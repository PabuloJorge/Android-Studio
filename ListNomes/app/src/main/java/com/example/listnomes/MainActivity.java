package com.example.listnomes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_nomes = findViewById(R.id.lv_nomes);

        ArrayList<String> nomes = new ArrayList<>();

        nomes.add("Pablo");
        nomes.add("Pedro");
        nomes.add("Paloma");

        ArrayAdapter adapterNomes = new ArrayAdapter(
                this, android.R.layout.simple_list_item_1, nomes
        );

        lv_nomes.setAdapter(adapterNomes);

        lv_nomes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Olá, "+nomes.get(i)+"!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}