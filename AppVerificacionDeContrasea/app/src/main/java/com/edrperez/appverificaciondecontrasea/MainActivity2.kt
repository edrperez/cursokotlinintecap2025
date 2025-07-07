package com.edrperez.appverificaciondecontrasea

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var tvMensaje: TextView
    private lateinit var tvDetalles: TextView
    private lateinit var ivIcono: ImageView
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        initComponents()
        mostrarResultado()
        setupListeners()
    }

    private fun initComponents() {
        tvMensaje = findViewById(R.id.tvMensaje)
        tvDetalles = findViewById(R.id.tvDetalles)
        ivIcono = findViewById(R.id.ivIcono)
        btnVolver = findViewById(R.id.btnVolver)
    }

    private fun mostrarResultado() {
        val password = intent.getStringExtra("PASSWORD") ?: ""
        val esSegura = intent.getBooleanExtra("ES_SEGURA", false)

        if (esSegura) {
            // Contraseña segura
            tvMensaje.text = "Contraseña segura"
            tvDetalles.text = "Tu contraseña tiene ${password.length} caracteres y cumple con los requisitos de seguridad."
            ivIcono.setImageResource(R.drawable.ic_seguro)

            // Cambiar color de fondo
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.clResultado)
                .setBackgroundColor(getColor(R.color.background_seguro))
        } else {
            // Contraseña débil
            tvMensaje.text = "Contraseña débil"
            tvDetalles.text = "Tu contraseña tiene ${password.length} caracteres. Se recomienda usar al menos 8 caracteres para mayor seguridad."
            ivIcono.setImageResource(R.drawable.ic_debil)

            // Cambiar color de fondo
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.clResultado)
                .setBackgroundColor(getColor(R.color.background_debil))
        }
    }

    private fun setupListeners() {
        btnVolver.setOnClickListener {
            finish()
        }
    }
}