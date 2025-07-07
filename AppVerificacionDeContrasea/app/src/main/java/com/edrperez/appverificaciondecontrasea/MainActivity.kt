package com.edrperez.appverificaciondecontrasea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etPassword: EditText
    private lateinit var btnVerificar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        setupListeners()
    }

    private fun initComponents() {
        etPassword = findViewById(R.id.etPassword)
        btnVerificar = findViewById(R.id.btnVerificar)
    }

    private fun setupListeners() {
        btnVerificar.setOnClickListener {
            verificarPassword()
        }

        // Listener para cuando se presiona Enter o Done en el teclado
        etPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_DONE ||
                actionId == android.view.inputmethod.EditorInfo.IME_ACTION_GO) {
                verificarPassword()
                true
            } else {
                false
            }
        }
    }
    private fun verificarPassword() {
        val password = etPassword.text.trim().toString()

        if (password.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa una contraseña.", Toast.LENGTH_SHORT).show()
            return
        }

        // Verificar que no contenga espacios en blanco
        if (password.contains(" ")) {
            Toast.makeText(this, "La contraseña no puede contener espacios en blanco.", Toast.LENGTH_SHORT).show()
            return
        }

        // Determinar si la contraseña es segura o débil
        val esSegura = password.length >= 8

        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("PASSWORD", password)
        intent.putExtra("ES_SEGURA", esSegura)
        startActivity(intent)
    }
}