package com.clari.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Suma extends AppCompatActivity {

    private EditText numero1, numero2;
    private TextView resultado;
    private Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma);

        numero1 = (EditText) findViewById(R.id.numero_suma_1);
        numero2 = (EditText) findViewById(R.id.numero_suma_2);
        resultado = (TextView) findViewById(R.id.resultado_suma);
        btn_calcular = (Button) findViewById(R.id.btnCalcularSuma);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumar();
            }
        });
    }

    private void sumar() {
        int num1 = Integer.parseInt(numero1.getText().toString());
        int num2 = Integer.parseInt(numero2.getText().toString());

        int suma = num1 + num2;
        resultado.setText(String.valueOf(suma));
    }

    public void volverActivity(View v) {
        Intent main_activity = new Intent(this, MainActivity.class);
        startActivity(main_activity);
    }
}