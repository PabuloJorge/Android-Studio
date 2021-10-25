package com.example.aplicativoea.localizador;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aplicativoea.MainActivity;
import com.example.aplicativoea.R;
import com.example.aplicativoea.UsuarioActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LocalizarFragment extends Fragment {

    EditText et_placa;
    Button bt_localizar;
    TextView tv_ano, tv_modelo;
    String placa;
    ScrollView sv_detalhesPlaca;

    String url = "http://192.168.0.108/app/teste/getCarro.php";

    RequestQueue requestQueue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_localizar_localizador, container, false);

        et_placa = view.findViewById(R.id.et_placa);
        bt_localizar = view.findViewById(R.id.bt_localizar);
        tv_ano = view.findViewById(R.id.tv_ano);
        tv_modelo = view.findViewById(R.id.tv_modelo);
        sv_detalhesPlaca = view.findViewById(R.id.sv_detalhesPlaca);


        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());


        bt_localizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sv_detalhesPlaca.setVisibility(View.INVISIBLE);
                boolean validado = true;
                placa = et_placa.getText().toString().trim();

                if (placa.isEmpty()) {
                    et_placa.setError("Campo obrigatório");
                    et_placa.requestFocus();
                    validado = false;
                } else if (placa.length() < 7) {
                    et_placa.setError("Placa incompleta");
                    et_placa.requestFocus();
                    validado = false;
                }


                if (validado) {
                    consultarPlaca();
                }


            }
        });

        return view;
    }

    private void consultarPlaca() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean isErro = jsonObject.getBoolean("erro");

                            if (isErro){
                                Toast.makeText(getActivity().getApplicationContext(), "Placa não encontrada", Toast.LENGTH_SHORT).show();
                            }else{
                                String ano = jsonObject.getString("ano");
                                String modelo = jsonObject.getString("modelo");

                                tv_ano.setText(ano);
                                tv_modelo.setText(modelo);

                                sv_detalhesPlaca.setVisibility(View.VISIBLE);

                            }
                        } catch (Exception e) {
                            Log.v("LogLogin", e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("LogLogin", error.getMessage());

                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("placa", placa);

                return params;
            }
        };
        requestQueue.getCache().clear();
        requestQueue.add(stringRequest);
    }
}
