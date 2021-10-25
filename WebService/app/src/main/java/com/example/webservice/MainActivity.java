package com.example.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainActivity extends AppCompatActivity {
    EditText et_login, et_senha;
    Button bt_login;

    String login, senha;

    String url = "https://192.168.0.108/youtube/getUsuarios.php";
    StringRequest stringRequest;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_login = findViewById(R.id.et_login);
        et_senha = findViewById(R.id.et_senha);
        bt_login = findViewById(R.id.bt_login);

        requestQueue = Volley.newRequestQueue(this);

        handleSSLHandshake();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validado = true;

                login = et_login.getText().toString().trim();
                senha = et_senha.getText().toString().trim();

                if (senha.isEmpty()) {
                    et_senha.setError("Campo obrigatório");
                    et_senha.requestFocus();
                    validado = false;
                }
                if (login.isEmpty()) {
                    et_login.setError("Campo obrigatório");
                    et_login.requestFocus();
                    validado = false;
                }

                if (validado) {
                    Toast.makeText(MainActivity.this, "Validando seus dados... Espere.... ",
                            Toast.LENGTH_SHORT).show();
                    validarLogin();
                }

            }
        });
    }

    private void validarLogin() {
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean isErro = jsonObject.getBoolean("erro");

                            if (isErro){
                                Toast.makeText(MainActivity.this, "Login ou senha inválidos", Toast.LENGTH_SHORT).show();
                            }else{
                                int perfil = jsonObject.getInt("fk_id_perfil");

                                if (perfil == 2){
                                    Intent i = new Intent(MainActivity.this, AdministradorActivity.class);
                                    startActivity(i);
                                    finish();
                                } else{
                                    Intent i = new Intent(MainActivity.this, UsuarioActivity.class);
                                    startActivity(i);
                                    finish();
                                }
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
                params.put("login", login);
                params.put("senha", senha);

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    /**
     * Enables https connections
     */
    @SuppressLint("TrulyRandom")
    public static void handleSSLHandshake() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
        } catch (Exception ignored) {
        }
    }


}