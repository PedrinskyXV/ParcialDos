package com.example.parcialdos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imgCompra, imgPuntos;
    String titulo= "Puntos por compras";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(titulo);
        imgCompra = (ImageView) findViewById(R.id.btnCompra);
        imgCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "Registrar compra",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),registroCompra.class);
                startActivity(intent);
            }
        });
        imgPuntos = (ImageView) findViewById(R.id.btnConsulta);
        imgPuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "Consultar puntos",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),consultaPuntos.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuoverflow,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.btnIntegrantes){
            Intent intent = new Intent(getApplicationContext(),integrantes.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}