package com.example.a05_listview.actividades;

import android.content.Intent;
import android.os.Bundle;

import com.example.a05_listview.actividades.adapters.AdapterNotas;
import com.example.a05_listview.actividades.modelos.Nota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.a05_listview.R;

import java.util.ArrayList;

public class InicioActivity extends AppCompatActivity {

    public static final int EDIT_ACTIVITY = 23;
    private final int NEW_NOTA_ACTIVITY = 13;
    //Contenedor de la Información
    private ListView contenedor;
    //Fila que se replica en el contenedro
    private int filaNota;
    //Conjunto de datos
    private ArrayList<Nota> listaNotas;
    //Adapter de Notas
    private AdapterNotas notasAdapter;
    private Button crearNota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contenedor = findViewById(R.id.contenedorMain);
        filaNota = R.layout.fila_nota;
        listaNotas = new ArrayList<>();
        notasAdapter = new AdapterNotas(this, filaNota, listaNotas);
        contenedor.setAdapter(notasAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //inicializarNotas();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == EDIT_ACTIVITY){
            if (data!= null){
                Nota nota = data.getExtras().getParcelable("NOTA");
                int posicion = data.getExtras().getParcelable("POS");
                listaNotas.set(posicion, nota);
                notasAdapter.notifyDataSetChanged();
            }
        }

        if (resultCode == RESULT_OK && requestCode == NEW_NOTA_ACTIVITY){
            if (data!=null){
                Nota nota = data.getExtras().getParcelable("NOTA");
                listaNotas.add(0, nota);
                notasAdapter.notifyDataSetChanged();
            }
        }
    }



    private void inicializarNotas(){
        for (int i = 0; i < 10 ; i++) {
            Nota nota = new Nota("Titulo "+i, "Este es mi contenido");
            listaNotas.add(nota);
        }
        notasAdapter.notifyDataSetChanged();
    }
}