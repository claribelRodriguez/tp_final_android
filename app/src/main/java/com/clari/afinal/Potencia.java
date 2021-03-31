package com.clari.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Potencia extends AppCompatActivity {

    private EditText numero1, numero2;
    private Button btnCalcular;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potencia);

        numero1 = (EditText) findViewById(R.id.numero_poten_1);
        numero2 = (EditText) findViewById(R.id.numero_poten_2);
        btnCalcular = (Button) findViewById(R.id.btnCalcularPoten);
        resultado = (TextView) findViewById(R.id.resultadoPoten);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                potencia();
            }
        });
    }

    private void potencia() {
        int num1 = Integer.parseInt(numero1.getText().toString());
        int num2 = Integer.parseInt(numero2.getText().toString());

        int elevar = (int) Math.pow(num1, num2);
        resultado.setText(String.valueOf(elevar));
    }

    public void volverActivity(View v) {
        Intent main_activity = new Intent(this, MainActivity.class);
        startActivity(main_activity);
    }
}