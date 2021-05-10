package com.example.parcialdos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.database.Cursor;
import android.os.Bundle;

public class consultaPuntos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_puntos);

        AppDataBase db = Room.databaseBuilder(this,AppDataBase.class,"database-name").allowMainThreadQueries().build();

        Cursor c = db.query("SELECT SUM(monto) FROM factura", null);
        double sumaMontos = c.getDouble(0);
        
    }
}