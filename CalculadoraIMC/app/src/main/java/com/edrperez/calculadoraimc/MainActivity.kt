package com.edrperez.calculadoraimc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnBorrarDatos: Button
    private lateinit var tvNombreGuardado: TextView
    private lateinit var tvImcGuardado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        etNombre = findViewById(R.id.etNombre)
        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnBorrarDatos = findViewById(R.id.btnBorrarDatos)
        tvNombreGuardado = findViewById(R.id.tvNombreGuardado)
        tvImcGuardado = findViewById(R.id.tvImcGuardado)

        // Cargar datos guardados
        cargarDatosGuardados()

        // Configurar botones
        btnCalcular.setOnClickListener {
            calcularIMC()
        }

        btnBorrarDatos.setOnClickListener {
            borrarDatosGuardados()
        }
    }

    private fun calcularIMC() {
        val nombre = etNombre.text.toString().trim()
        val pesoStr = etPeso.text.toString().trim()
        val alturaStr = etAltura.text.toString().trim()

        // Validar campos
        if (nombre.isEmpty() || pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val peso = pesoStr.toDouble()
            val altura = alturaStr.toDouble()

            // Validar valores
            if (peso <= 0 || altura <= 0) {
                Toast.makeText(this, "Los valores deben ser mayores a 0", Toast.LENGTH_SHORT).show()
                return
            }

            // Calcular IMC
            val imc = (peso / 2.204) / (altura * altura)

            // Guardar en SharedPreferences
            val sharedPref = getSharedPreferences("IMC_DATA", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("nombre", nombre)
                putFloat("imc", imc.toFloat())
                apply()
            }

            // Navegar a MainActivity2
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("imc", imc)
            startActivity(intent)

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Por favor ingresa valores numéricos válidos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cargarDatosGuardados() {
        val sharedPref = getSharedPreferences("IMC_DATA", Context.MODE_PRIVATE)
        val nombreGuardado = sharedPref.getString("nombre", null)
        val imcGuardado = sharedPref.getFloat("imc", 0f)

        if (nombreGuardado != null && imcGuardado > 0) {
            tvNombreGuardado.text = "Último usuario: $nombreGuardado"
            tvImcGuardado.text = "Último IMC: ${String.format("%.2f", imcGuardado)}"
            tvNombreGuardado.visibility = TextView.VISIBLE
            tvImcGuardado.visibility = TextView.VISIBLE
            btnBorrarDatos.visibility = Button.VISIBLE
        } else {
            tvNombreGuardado.visibility = TextView.GONE
            tvImcGuardado.visibility = TextView.GONE
            btnBorrarDatos.visibility = Button.GONE
        }
    }

    private fun borrarDatosGuardados() {
        val sharedPref = getSharedPreferences("IMC_DATA", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            clear()
            apply()
        }

        // Actualizar la interfaz
        cargarDatosGuardados()

        // Mostrar mensaje de confirmación
        Toast.makeText(this, "Datos borrados exitosamente", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        // Recargar datos cuando se regrese a la actividad
        cargarDatosGuardados()
    }
}