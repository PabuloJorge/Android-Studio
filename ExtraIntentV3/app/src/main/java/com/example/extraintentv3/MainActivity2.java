package com.example.extraintentv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText et_num2;
    Button bt_ok2;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_num2 = findViewById(R.id.et_num2);
        bt_ok2 = findViewById(R.id.bt_ok2);

        i = getIntent();

        bt_ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (et_num2.getText().toString().isEmpty() || Double.parseDouble(et_num2.getText().toString()) == 0) {
                    Toast.makeText(MainActivity2.this, "Digite um valor maior que 0",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent i2 = new Intent(MainActivity2.this, MainActivity3.class);
                    i2.putExtra("num1", i.getStringExtra("num1"));
                    i2.putExtra("num2", et_num2.getText().toString());
                    startActivity(i2);
                }

            }
        });
    }
}