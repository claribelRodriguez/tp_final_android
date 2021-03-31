package com.clari.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Raiz extends AppCompatActivity {

    private EditText numero1;
    private Button btnCalcular;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiz);

        numero1 = (EditText) findViewById(R.id.numero_raiz_1);
        btnCalcular = (Button) findViewById(R.id.btnCalcularRaiz);
        resultado = (TextView) findViewById(R.id.resultadoRaiz);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raiz();
            }
        });
    }

    private void raiz() {
        int num1 = Integer.parseInt(numero1.getText().toString());

        int sacar_raiz = (int) Math.sqrt(num1);
        resultado.setText(String.valueOf(sacar_raiz));
    }

    public void volverActivity(View v) {
        Intent main_activity = new Intent(this, MainActivity.class);
        startActivity(main_activity);
    }
}