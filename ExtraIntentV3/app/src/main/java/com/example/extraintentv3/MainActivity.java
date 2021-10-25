package com.example.extraintentv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_num1;
    Button bt_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_num1 = findViewById(R.id.et_num1);
        bt_ok = findViewById(R.id.bt_ok);


        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_num1.getText().toString().isEmpty() || Double.parseDouble(et_num1.getText().toString()) == 0) {
                    Toast.makeText(MainActivity.this, "Digite um valor maior que 0",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("num1", et_num1.getText().toString());
                    startActivity(i);
                }

            }
        });

    }
}