package com.example.a05_listview.actividades.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a05_listview.R;
import com.example.a05_listview.actividades.InicioActivity;
import com.example.a05_listview.actividades.modelos.EditActivity;
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
    public View getView(final int posicion, @Nullable View convertView, @NonNull ViewGroup parent){
        View fila = LayoutInflater.from(context).inflate(resource, null);
        final Nota nota = objects.get(posicion);

        TextView txtTitulo = fila.findViewById(R.id.txtTituloFilaNota);
        Button btnEliminar = fila.findViewById(R.id.btnEliminarFilaNota);

        txtTitulo.setText(nota.getTitulo());

        //Faltan los OnClickListener
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objects.remove(posicion);
                notifyDataSetChanged();
            }
        });

        txtTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putParcelable("NOTA", nota);
                bundle.putInt("POS", posicion);

                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtras(bundle);

                ((Activity)context).startActivityForResult(intent, InicioActivity.EDIT_ACTIVITY);
            }
        });

        return fila;
    }
}
