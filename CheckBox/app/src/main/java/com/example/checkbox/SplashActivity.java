package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        i = getIntent();
        String pedido = i.getStringExtra("pedido");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                i = new Intent(SplashActivity.this, ResumoPedidoActivity.class);
                i.putExtra("pedido", pedido);
                startActivity(i);
            }
        }, 4000);
    }
}