package com.example.navbottom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InicioFragment extends Fragment {
    EditText et_nome;
    Button bt_confirmar;
    TextView tv_nome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
// linkar com o componente da view
        et_nome = view.findViewById(R.id.et_nome);
        bt_confirmar = view.findViewById(R.id.bt_confirmar);
        tv_nome = view.findViewById(R.id.et_nome);
        
        bt_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = et_nome.getText().toString().trim();
                
                if (nome.isEmpty()){
                    Toast.makeText(getActivity().getApplicationContext(), "Digite seu nome", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}
