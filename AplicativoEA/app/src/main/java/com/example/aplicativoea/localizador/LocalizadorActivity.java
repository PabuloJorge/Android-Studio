package com.example.aplicativoea.localizador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.aplicativoea.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class LocalizadorActivity extends AppCompatActivity {
    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizador);

        bnv = findViewById(R.id.bnv_localizador);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_localizador,
                new InicioFragment()).commit();

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selecionadoFragment = null;

                switch (item.getItemId()) {
                    case R.id.i_inicio:
                        selecionadoFragment = new InicioFragment();
                        break;
                    case R.id.i_perfil:
                        selecionadoFragment = new PerfilFragment();
                        break;
                    case R.id.i_buscar:
                        selecionadoFragment = new LocalizarFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fl_localizador,
                        selecionadoFragment).commit();
                return true;
            }
        });
    }
}