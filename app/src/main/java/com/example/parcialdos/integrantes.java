package com.example.parcialdos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class integrantes extends AppCompatActivity {
    FloatingActionButton btnRegresar;
    WebView html;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrantes);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(act);
            }
        });
        html = findViewById(R.id.wvContenido);
        String texto;
        texto = "<html><body>";
        texto+="<div style=\"border-radius: 25px; border-style:solid;background-color: #046cb4;";
        texto+="padding: 10px;border-width: 2px\">";
        texto+="<p align=\"justify\" style=\"color: white\">";
        texto+="<strong>Integrantes:</strong><br>Milton Gerardo Aguilera Ramos<span style=\"display: none;\"><br> Josue Salvador Reyes Melgar</span><br> Pedro Alexander Perez Rosales<br>William Alexander V&aacutesquez Hern&aacutendez</p>";
        texto +="</p></div></body></html>";
        html.loadData(texto,"text/html","utf-8");
    }
}