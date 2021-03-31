package com.clari.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Division extends AppCompatActivity {

    private EditText numero1, numero2;
    private Button btnCalcular;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

        numero1 = (EditText) findViewById(R.id.numero_div_1);
        numero2 = (EditText) findViewById(R.id.numero_div_2);
        btnCalcular = (Button) findViewById(R.id.btnCalcularDiv);
        resultado = (TextView) findViewById(R.id.resultado_div);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                division();
            }
        });
    }

    private void division() {
        int num1 = Integer.parseInt(numero1.getText().toString());
        int num2 = Integer.parseInt(numero2.getText().toString());

        if (num2 == 0) {
            Toast.makeText(Division.this, "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
        }
        else {
            int dividir = num1 * num2;
            resultado.setText(String.valueOf(dividir));
        }
    }

    public void volverActivity(View v) {
        Intent main_activity = new Intent(this, MainActivity.class);
        startActivity(main_activity);
    }
}