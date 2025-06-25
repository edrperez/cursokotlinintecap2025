package com.edrperez.appactividadconvertidortemperatura

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etTemperatura: EditText
    private lateinit var btnConvertir: Button
    private lateinit var tvResultado: TextView
    private lateinit var tvUnidadActual: TextView

    // Variable para controlar el modo de conversión
    // true = Celsius a Fahrenheit, false = Fahrenheit a Celsius
    private var celsiusAFahrenheit = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar las vistas
        inicializarVistas()

        // Configurar el evento del botón
        configurarBoton()

        // Configurar el estado inicial
        actualizarInterfaz()
    }

    private fun inicializarVistas() {
        etTemperatura = findViewById(R.id.etTemperatura)
        btnConvertir = findViewById(R.id.btnConvertir)
        tvResultado = findViewById(R.id.tvResultado)
        tvUnidadActual = findViewById(R.id.tvUnidadActual)
    }

    private fun configurarBoton() {
        btnConvertir.setOnClickListener {
            convertirTemperatura()
        }

        // Configurar click en el TextView de unidad para cambiar modo
        tvUnidadActual.setOnClickListener {
            cambiarModoConversion()
        }
    }

    private fun convertirTemperatura() {
        // Ocultar el teclado
        ocultarTeclado()

        val inputText = etTemperatura.text.toString().trim()

        // Verificar si el campo está vacío
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa una temperatura", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val temperatura = inputText.toDouble()
            val resultado: Double

            if (celsiusAFahrenheit) {
                // Convertir de Celsius a Fahrenheit: F = (C × 9/5) + 32
                resultado = (temperatura * 9/5) + 32
                tvResultado.text = String.format("%.1f°C = %.1f°F", temperatura, resultado)
            } else {
                // Convertir de Fahrenheit a Celsius: C = (F - 32) × 5/9
                resultado = (temperatura - 32) * 5/9
                tvResultado.text = String.format("%.1f°F = %.1f°C", temperatura, resultado)
            }

            // Reusando la idea de la otra aplicación para cambiar color según la temperatura
            // en Celsius
            val tempEnCelsius = if (celsiusAFahrenheit) temperatura else resultado
            when {
                tempEnCelsius < 0 -> tvResultado.setTextColor(Color.BLUE) // Frío
                tempEnCelsius <= 25 -> tvResultado.setTextColor(Color.GREEN) // Templado
                else -> tvResultado.setTextColor(Color.RED) // Caliente
            }

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Por favor ingresa una temperatura válida", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cambiarModoConversion() {
        celsiusAFahrenheit = !celsiusAFahrenheit
        actualizarInterfaz()
        // Limpiar campos
        etTemperatura.text.clear()
        tvResultado.text = ""
    }

    private fun actualizarInterfaz() {
        if (celsiusAFahrenheit) {
            tvUnidadActual.text = "Celsius (°C) → Fahrenheit (°F)"
            etTemperatura.hint = "Ej: 25, 0, -10"
        } else {
            tvUnidadActual.text = "Fahrenheit (°F) → Celsius (°C)"
            etTemperatura.hint = "Ej: 77, 32, 14"
        }
    }

    private fun ocultarTeclado() {
        //Copiado de internet, jajajaja
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocusedView = currentFocus
        currentFocusedView?.let {
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}