package com.clari.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Resta extends AppCompatActivity {

    private EditText numero1, numero2;
    private Button btnCalcular;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resta);

        numero1 = (EditText) findViewById(R.id.numero_resta_1);
        numero2 = (EditText) findViewById(R.id.numero_resta_2);
        btnCalcular = (Button) findViewById(R.id.btnCalcuarResta);
        resultado = (TextView) findViewById(R.id.resultado_resta);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restar();
            }
        });
    }

    private void restar() {
        int num1 = Integer.parseInt(numero1.getText().toString());
        int num2 = Integer.parseInt(numero2.getText().toString());

        int resta = num1 - num2;
        resultado.setText(String.valueOf(resta));
    }

    public void volverActivity(View v) {
        Intent main_activity = new Intent(this, MainActivity.class);
        startActivity(main_activity);
    }
}