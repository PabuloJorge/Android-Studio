package com.example.googlemapsv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_locais;
    ArrayList<Local> locais;
    ArrayAdapter<Local> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_locais = findViewById(R.id.lv_locais);
        locais = new ArrayList<>();

        Local l1 = new Local("Condomínio Maurício de Nassau", -8.115047, -35.027541);

        Local l2 = new Local("Super Mercado Nordeste", -8.113177, -35.018807);

        Local l3 = new Local("IEADPE Jaboatão - Templo Matrix", -8.114505, -35.017542);

        locais.add(l1);
        locais.add(l2);
        locais.add(l3);

        adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, locais
        );

        lv_locais.setAdapter(adapter);

        lv_locais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("titulo", locais.get(i).getTitulo());
                intent.putExtra("lat", locais.get(i).getLat());
                intent.putExtra("lon", locais.get(i).getLon());
                startActivity(intent);
            }
        });
    }
}















