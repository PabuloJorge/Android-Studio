package com.example.navbottom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bnv);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl,
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
                        selecionadoFragment = new BuscarFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fl,
                        selecionadoFragment).commit();
                return true;
            }
        });
//        bnv.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem item) {
//                Fragment selecionadoFragment = null;
//
//                switch (item.getItemId()) {
//                    case R.id.i_inicio:
//                        selecionadoFragment = new InicioFragment();
//                        break;
//                    case R.id.i_perfil:
//                        selecionadoFragment = new PerfilFragment();
//                        break;
//                    case R.id.i_buscar:
//                        selecionadoFragment = new BuscarFragment();
//                        break;
//                }
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl,
//                        selecionadoFragment).commit();
//            }
//        });
    }
}