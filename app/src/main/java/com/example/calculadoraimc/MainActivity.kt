package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etAltura = findViewById<EditText>(R.id.etAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val peso = etPeso.text.toString().toFloatOrNull()
            val altura = etAltura.text.toString().toFloatOrNull()

            if (peso != null && altura != null && altura > 0) {
                // Corrija a altura para garantir que seja em metros
                val alturaEmMetros = altura / 100  // Se a altura estiver em centímetros
                val imc = peso / (alturaEmMetros * alturaEmMetros)
                tvResultado.text = "IMC: %.2f".format(imc)
            } else {
                tvResultado.text = "Entrada inválida"
            }
        }
    }
}
