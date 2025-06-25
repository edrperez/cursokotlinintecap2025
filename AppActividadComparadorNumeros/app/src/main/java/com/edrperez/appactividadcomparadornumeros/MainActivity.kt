package com.edrperez.appactividadcomparadornumeros

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

    private lateinit var etNumero: EditText
    private lateinit var btnRevisar: Button
    private lateinit var tvResultado: TextView

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
    }

    private fun inicializarVistas() {
        etNumero = findViewById(R.id.etNumero)
        btnRevisar = findViewById(R.id.btnRevisar)
        tvResultado = findViewById(R.id.tvResultado)
    }

    private fun configurarBoton() {
        btnRevisar.setOnClickListener {
            revisarNumero()
        }
    }

    private fun revisarNumero() {
        // Ocultar el teclado
        ocultarTeclado()

        val inputText = etNumero.text.toString().trim()

        // Verificar si el campo está vacío
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa un número", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val numero = inputText.toDouble()

            when {
                numero > 0 -> {
                    // Número positivo - Verde
                    tvResultado.text = "El número $numero es POSITIVO"
                    tvResultado.setTextColor(Color.GREEN)
                }
                numero < 0 -> {
                    // Número negativo - Negro
                    tvResultado.text = "El número $numero es NEGATIVO"
                    tvResultado.setTextColor(Color.RED)
                }
                else -> {
                    // Número igual a cero - Azul
                    tvResultado.text = "El número es CERO"
                    tvResultado.setTextColor(Color.BLUE)
                }
            }

        } catch (e: NumberFormatException) {
            // Error al convertir el texto a número
            Toast.makeText(this, "Por favor ingresa un número válido", Toast.LENGTH_SHORT).show()
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