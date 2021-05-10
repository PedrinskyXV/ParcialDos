package com.example.parcialdos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class registroCompra extends AppCompatActivity {
    private Spinner spinner;
    Button btnRegistrar;
    ImageView imgCalendar;
    String titulo= "Registro de compras", seleccion;
    Calendar cal;
    DatePickerDialog pickerDialog;
    EditText factura,fecha, monto;
    TextView txv_resultados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_compra);
        this.setTitle(titulo);
        factura = findViewById(R.id.edtFactura);
        spinner = (Spinner)findViewById(R.id.spinner);
        String[] gasofa = {"Seleccione","Diesel", "Premium", "Regular"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,gasofa);
        spinner.setAdapter(adapter);
        imgCalendar = (ImageView) findViewById(R.id.btnCalendar);
        fecha = (EditText) findViewById(R.id.edtFecha);
        monto = findViewById(R.id.edtMonto);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        imgCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Seleccione fecha",
                        Toast.LENGTH_LONG).show();
                cal = Calendar.getInstance();
                int dia = cal.get(Calendar.DAY_OF_MONTH);
                int mes = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);
                pickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                            }
                        }, year, mes, dia);
                        pickerDialog.show();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String auxFactura = factura.getText().toString();
                seleccion = spinner.getSelectedItem().toString();
                String auxFecha =  fecha.getText().toString();
                String auxMonto = monto.getText().toString();
                if(!auxFactura.equals("") && !auxFecha.equals("Fe/c/ha") && !seleccion.equals("Seleccione") && !auxMonto.equals(""))
                {
                    float puto = Float.parseFloat(auxMonto);

                    AppDataBase base = Room.databaseBuilder(v.getContext(),
                            AppDataBase.class,"dbFactura")
                            .allowMainThreadQueries().build();
                    Factura fact = new Factura(
                            auxFactura,
                            auxFecha,
                            seleccion,
                            puto
                    );
                    Long register = base.daoFactura().insertFact(fact);
                    factura.setText("");
                    fecha.setText("");
                    monto.setText("");
                    spinner.setSelection(0);



                    //comentar esta no mas para pruebas el mostrar
                    List<Factura> lista = base.daoFactura().getAll();
                    String aux = "";
                    for (int i=0; i<lista.size(); i++)
                    {
                        aux += "id: " + lista.get(i).registro +
                                " factura: " + lista.get(i).nFactura +
                                " fecha: " + lista.get(i).fecha +
                                " monto: " + lista.get(i).monto +"\n";
                    }
                    txv_resultados = findViewById(R.id.edtResultados);
                    txv_resultados.setText(aux);

                    int numFac = base.daoFactura().numeroFacturas();
                    int punto = (int)puto;

                    if(numFac == 1){

                        Punto p = new Punto(punto);
                        Long pu = base.daoPunto().insertPu(p);
                    }
                    else{
                        base.daoPunto().sumarPuntos(punto);
                    }

                    String aux2 = "";
                    List<Punto> lista2 = base.daoPunto().getAll();

                    for (int i = 0; i < lista2.size(); i++)
                    {
                        aux2 += "id: " + lista2.get(i).idPunto + " monto: " + lista2.get(i).punto +"\n";
                    }

                    //aqui hacer el count a punto mira dao o intenta helpers como te sea mas facil dependemos del idPunto=1
                    Log.i("alv","intero: "+punto+" , float: "+puto + ", NFac " + numFac + ", punto: " + aux2);
                    /*Intent act = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(act);*/
                }
                else {
                    //solo pruebas
                    AppDataBase base = Room.databaseBuilder(v.getContext(),
                            AppDataBase.class,"dbFactura")
                            .allowMainThreadQueries().build();
                    List<Factura> lista = base.daoFactura().getAll();
                    String aux = "";
                    for (int i=0; i<lista.size(); i++)
                    {
                        aux += "id: " + lista.get(i).registro +
                                " factura: " + lista.get(i).nFactura +
                                " fecha: " + lista.get(i).fecha +
                                " monto: " + lista.get(i).monto +"\n";
                    }
                    txv_resultados = findViewById(R.id.edtResultados);
                    txv_resultados.setText(aux);
                    //
                    Toast.makeText(v.getContext(), "Campos requeridos",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}