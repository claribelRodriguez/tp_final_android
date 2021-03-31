package com.clari.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner tipoOperacion;
    private Button btnOperaciones;
    private ImageButton ir_documentacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipoOperacion = (Spinner) findViewById(R.id.ContraintLayout);
        btnOperaciones = (Button) findViewById(R.id.btn_operaciones);
        ir_documentacion = (ImageButton) findViewById(R.id.documentacion);

        String [] listaOperaciones = {"Suma", "Resta", "Multiplicacion", "Division", "Potencia", "Raiz"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaOperaciones);
        tipoOperacion.setAdapter(adapter);

        btnOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operaciones();
            }
        });

        ir_documentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Documentacion();
            }
        });
    }

    private void Documentacion() {
        Intent intent = new Intent(this, Documentacion.class);
        startActivity(intent);
    }

    private void operaciones() {
        String seleccionado = tipoOperacion.getSelectedItem().toString();

        switch (seleccionado) {
            case "Suma":
                Intent suma = new Intent(this, Suma.class);
                startActivity(suma);
                break;
            case "Resta":
                Intent resta = new Intent(this, Resta.class);
                startActivity(resta);
                break;
            case "Multiplicacion":
                Intent multiplicacion = new Intent(this, Multiplicar.class);
                startActivity(multiplicacion);
                break;
            case "Division":
                Intent division = new Intent(this, Division.class);
                startActivity(division);
                break;
            case "Potencia":
                Intent potencia = new Intent(this, Potencia.class);
                startActivity(potencia);
                break;
            case "Raiz":
                Intent raiz = new Intent(this, Raiz.class);
                startActivity(raiz);
                break;
        }
    }
}