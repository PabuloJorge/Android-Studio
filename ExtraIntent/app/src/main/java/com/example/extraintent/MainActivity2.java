package com.example.extraintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Intent i;
    TextView tv_ola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        i = getIntent();
        tv_ola = findViewById(R.id.tv_ola);
        tv_ola.setText("Olá, "+i.getStringExtra("nome"));
    }
}