package com.edrperez.appclasificacionporedad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etEdad: EditText
    private lateinit var btnContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        setupListeners()
    }

    private fun initComponents() {
        etEdad = findViewById(R.id.etEdad)
        btnContinuar = findViewById(R.id.btnContinuar)
    }

    private fun setupListeners() {
        btnContinuar.setOnClickListener {
            procesarEdad()
        }

        // Listener para cuando se presiona Enter o Done en el teclado
        etEdad.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_DONE ||
                actionId == android.view.inputmethod.EditorInfo.IME_ACTION_GO) {
                procesarEdad()
                true // Indica que el evento fue manejado
            } else {
                false
            }
        }
    }

    private fun procesarEdad() {
        val edadTexto = etEdad.text.toString()

        if (edadTexto.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa tu edad", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val edad = edadTexto.toInt()

            if (edad < 0) {
                Toast.makeText(this, "Por favor ingresa una edad válida", Toast.LENGTH_SHORT).show()
                return
            }

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("EDAD", edad)
            startActivity(intent)

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Por favor ingresa solo números", Toast.LENGTH_SHORT).show()
        }
    }
}