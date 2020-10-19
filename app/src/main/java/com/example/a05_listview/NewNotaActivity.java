package com.example.a05_listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a05_listview.actividades.modelos.Nota;

public class NewNotaActivity extends AppCompatActivity {


    private EditText etxtTitulo, etxtContenido;
    private Button btnGuardar;

    private Nota nota;
    private int posicion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        etxtTitulo = findViewById(R.id.etxtTituloEdit);
        etxtContenido = findViewById(R.id.etxtContenidoEdit);
        btnGuardar = findViewById(R.id.btnGuardarNotaEdit);

        nota = getIntent().getExtras().getParcelable("NOTA");
        posicion = getIntent().getExtras().getParcelable("POS");

        etxtTitulo.setText(nota.getTitulo());
        etxtContenido.setText(nota.getContenido());

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nota.setTitulo(etxtTitulo.getText().toString());
                nota.setContenido(etxtContenido.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putParcelable("NOTA", nota);
                bundle.putInt("POS", posicion);

                Intent intent = new Intent();
                intent.putExtras(bundle);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
