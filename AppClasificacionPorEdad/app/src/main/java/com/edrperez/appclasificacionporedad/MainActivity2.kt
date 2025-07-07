package com.edrperez.appclasificacionporedad

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var tvMensaje: TextView
    private lateinit var ivIcono: ImageView
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        initComponents()
        obtenerEdadYMostrarResultado()
        setupListeners()
    }

    private fun initComponents() {
        tvMensaje = findViewById(R.id.tvMensaje)
        ivIcono = findViewById(R.id.ivIcono)
        btnVolver = findViewById(R.id.btnVolver)
    }

    private fun obtenerEdadYMostrarResultado() {
        val edad = intent.getIntExtra("EDAD", 0)

        when {
            edad < 13 -> {
                tvMensaje.text = "Niño."
                ivIcono.setImageResource(R.drawable.ic_nino)
                // Cambiar color de fondo para niños
                findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.clResultado)
                    .setBackgroundColor(getColor(R.color.background_niño))
            }
            edad in 13..17 -> {
                tvMensaje.text = "Adolescente."
                ivIcono.setImageResource(R.drawable.ic_adolescente)
                // Cambiar color de fondo para adolescentes
                findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.clResultado)
                    .setBackgroundColor(getColor(R.color.background_adolescente))
            }
            else -> {
                tvMensaje.text = "Adulto."
                ivIcono.setImageResource(R.drawable.ic_adulto)
                // Cambiar color de fondo para adultos
                findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.clResultado)
                    .setBackgroundColor(getColor(R.color.background_adulto))
            }
        }
    }

    private fun setupListeners() {
        btnVolver.setOnClickListener {
            finish()
        }
    }
}