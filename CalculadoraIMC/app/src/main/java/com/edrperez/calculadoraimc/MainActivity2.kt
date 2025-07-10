package com.edrperez.calculadoraimc

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var tvResultado: TextView
    private lateinit var ivResultado: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Inicializar vistas
        tvResultado = findViewById(R.id.tvResultado)
        ivResultado = findViewById(R.id.ivResultado)

        // Obtener datos del Intent
        val nombre = intent.getStringExtra("nombre") ?: "Usuario"
        val imc = intent.getDoubleExtra("imc", 0.0)

        // Mostrar resultado
        mostrarResultado(nombre, imc)
    }

    private fun mostrarResultado(nombre: String, imc: Double) {
        // Formatear IMC a 2 decimales
        val imcFormateado = String.format("%.2f", imc)

        // Configurar texto
        tvResultado.text = "Hola $nombre, tu IMC es: $imcFormateado"

        // Determinar categoría y mostrar imagen correspondiente
        when {
            imc < 18.5 -> {
                ivResultado.setImageResource(R.drawable.bajo_peso)
            }
            imc < 25.0 -> {
                ivResultado.setImageResource(R.drawable.normal)
            }
            imc < 30.0 -> {
                ivResultado.setImageResource(R.drawable.sobrepeso)
            }
            else -> {
                ivResultado.setImageResource(R.drawable.obesidad)
            }
        }
    }
}