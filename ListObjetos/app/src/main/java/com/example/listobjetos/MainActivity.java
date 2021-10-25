package com.example.listobjetos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_users;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_users = findViewById(R.id.lv_users);

        users = new ArrayList<>();

        User userUm = new User();
        userUm.setLogin("Login 1");
        userUm.setSenha("Senha 1");

        User userDois = new User("Login 2", "Senha 2");

        User userTres = new User(userUm);

        users.add(userUm);
        users.add(userDois);
        users.add(userTres);

        ArrayAdapter<User> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, users
        );

        lv_users.setAdapter(adapter);

        lv_users.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "User clicado --> "+users.get(i).getLogin(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}