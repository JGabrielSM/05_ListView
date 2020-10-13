package com.example.a05_listview.actividades.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a05_listview.R;
import com.example.a05_listview.actividades.modelos.Nota;

import java.util.ArrayList;
import java.util.List;

public class AdapterNotas extends ArrayAdapter<Nota> {

    private Context context;
    private ArrayList<Nota> objects;
    private int resource;
    public AdapterNotas(@NonNull Context context, int resource, @NonNull ArrayList<Nota> objects) {
        super(context, resource, objects);

        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int posicion, @Nullable View convertView, @NonNull ViewGroup parent){
        View fila = LayoutInflater.from(context).inflate(resource, null);
        Nota nota = objects.get(posicion);

        TextView txtTitulo = fila.findViewById(R.id.txtTituloFilaNota);
        Button btnEliminar = fila.findViewById(R.id.btnEliminarFilaNota);

        txtTitulo.setText(nota.getTitulo());

        //Faltan los OnClickListener

        return fila;
    }
}
