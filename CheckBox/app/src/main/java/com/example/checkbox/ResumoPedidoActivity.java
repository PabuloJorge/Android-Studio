package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResumoPedidoActivity extends AppCompatActivity {
    TextView tv_pedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pedido);

        tv_pedido = findViewById(R.id.tv_pedido);
        Intent i = getIntent();
        String pedido = i.getStringExtra("pedido");
        tv_pedido.setText(pedido);
    }
}