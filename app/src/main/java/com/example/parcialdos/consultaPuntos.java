package com.example.parcialdos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class consultaPuntos extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView txv_puntos;

    int puntosFinal = 0;
    List<Canjear> datos = llenarConDatos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_puntos);

        cargarPuntos();

        ListView lvCanjes = (ListView) findViewById(R.id.list_canjes);
        lvCanjes.setOnItemClickListener(this);
        CanjearAdapter adapter = new CanjearAdapter(consultaPuntos.this,R.layout.row_layout, datos);
        lvCanjes.setAdapter(adapter);
    }

    public List<Canjear> llenarConDatos(){
        List<Canjear> data = new ArrayList<>();
        int icono = R.drawable.ic_exchange;

        data.add(new Canjear("2", "2", icono, 200));
        data.add(new Canjear("3", "3", icono, 300));
        data.add(new Canjear("4", "4", icono, 400));
        data.add(new Canjear("8", "8", icono, 800));
        data.add(new Canjear("15", "15", icono, 1500));

        return data;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int canje = datos.get(i).getValor();

        if(canje > puntosFinal)
        {
            mostrarMsj("PUNTOS INSUFICIENTES PARA EL CANJE :c");
        }
        else{
            mostrarAlerta(canje);
        }
    }

    public void mostrarAlerta(int val){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("CANJE DE PUNTOS");
        builder.setMessage("¿Desea cambiar sus puntos por el bono seleccionado?");

        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                canjearPuntos(val);
                mostrarMsj("LOS PUNTOS FUERON CANJEADOS");
                cargarPuntos();
            }
        });
        builder.setNegativeButton("NO", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void mostrarMsj(String msj){
        Toast.makeText(this,msj,Toast.LENGTH_SHORT).show();
    }

    public void cargarPuntos(){
        AppDataBase db = Room.databaseBuilder(this,AppDataBase.class,"dbFactura").allowMainThreadQueries().build();
        int numFac = db.daoFactura().numeroFacturas();

        if(numFac >= 1)
        {
            List<Punto> lista = db.daoPunto().getAll();
            puntosFinal = lista.get(0).punto;
        }

        String puntos = String.valueOf(puntosFinal);

        txv_puntos = findViewById(R.id.txv_puntos);
        txv_puntos.setText(puntos);
    }

    public void canjearPuntos(int restar){
        AppDataBase db = Room.databaseBuilder(this,AppDataBase.class,"dbFactura").allowMainThreadQueries().build();
        db.daoPunto().restarPuntos(restar);
    }




}