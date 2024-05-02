package com.example.a03projetos_02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etConsumoMedio, etQuantidadeCombustivel;
    private Button btnCalcular;
    private TextView tvAutonomia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etConsumoMedio = findViewById(R.id.et_consumo_medio);
        etQuantidadeCombustivel = findViewById(R.id.et_quantidade_combustivel);
        btnCalcular = findViewById(R.id.btn_calcular);
        tvAutonomia = findViewById(R.id.tv_autonomia);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularAutonomia();
            }
        });
    }

    private void calcularAutonomia() {
        String consumoMedioStr = etConsumoMedio.getText().toString();
        String quantidadeCombustivelStr = etQuantidadeCombustivel.getText().toString();

        if (!consumoMedioStr.isEmpty() && !quantidadeCombustivelStr.isEmpty()) {
            double consumoMedio = Double.parseDouble(consumoMedioStr);
            double quantidadeCombustivel = Double.parseDouble(quantidadeCombustivelStr);


            double autonomiaMetros = consumoMedio * quantidadeCombustivel * 1000;

            tvAutonomia.setText("Autonomia: " + String.format("%.2f", autonomiaMetros) + " metros");
        } else {
            Toast.makeText(this, "Por favor, insira o consumo médio e a quantidade de combustível.", Toast.LENGTH_SHORT).show();
        }
    }
}
