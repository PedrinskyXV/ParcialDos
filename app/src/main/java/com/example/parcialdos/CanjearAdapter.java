package com.example.parcialdos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collections;
import java.util.List;

public class CanjearAdapter extends ArrayAdapter<Canjear> {
    private List<Canjear> mList = Collections.emptyList();
    private Context mContext;
    private int resourceLayout;

    public CanjearAdapter(@NonNull Context context, int resource, List<Canjear> objects) {
        super(context, resource, objects);
        //Asignar valores de objetos
        this.mList = objects;
        this.mContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        //Crear un view
        View view=convertView;
        //Preguntar si el view no viene vacio
        if(view ==null)
            view = LayoutInflater.from(mContext).inflate(R.layout.row_layout,null);

        //Especificar posicion del elemento del view
        Canjear modelo = mList.get(position);
        //Especificar que encuentre los elementos del layout lugares

        ImageView imagen = view.findViewById(R.id.imgv_icono);
        imagen.setImageResource(modelo.getIcono());

        TextView titulo = view.findViewById(R.id.titulo);
        titulo.setText(modelo.getTitulo());

        TextView valor = view.findViewById(R.id.valor);
        valor.setText(String.valueOf(modelo.getValor()));

        TextView contenido = view.findViewById(R.id.descripcion);
        contenido.setText(modelo.getDescripcion());

        return view;

    }
}
