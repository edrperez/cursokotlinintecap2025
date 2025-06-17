package com.edrperez.actividadfundamentos

fun main(args: Array<String>) {
    println("=== BIENVENIDO AL PROGRAMA DE FUNDAMENTOS KOTLIN ===")
    println("Programa creado por: Rubén Edgar Raymundo Pérez González")
    println("=".repeat(60))

    println("\n=== DECLARACIÓN DE VARIABLES CON DIFERENTES TIPOS DE DATOS ===")

    // 10 val (inmutables)
    val nombre: String = "Rubén Edgar Raymundo Pérez González"
    val edad: Int = 42
    val altura: Double = 1.85
    val esEstudiante: Boolean = true
    val calificacion: Float = 9.5f
    val numeroLargo: Long = 1234567890L
    val letra: Char = 'R'
    val numeroByte: Byte = 127
    val numeroCorto: Short = 32000
    val pi: Double = 3.14159

    // 10 var (mutables)
    var ciudadActual: String = "Guatemala"
    var añoActual: Int = 2025
    var peso: Double = 79.5
    var tieneVehiculo: Boolean = false
    var promedio: Float = 88.7f
    var telefono: Long = 50212345678L
    var inicial: Char = 'E'
    var diasMes: Byte = 30
    var temperatura: Short = 25
    var descuento: Double = 0.15

    println("=== VALORES val (inmutables) ===")
    println("Nombre: $nombre")
    println("Edad: $edad años")
    println("Altura: $altura metros")
    println("Es estudiante: $esEstudiante")
    println("Calificación: $calificacion")
    println("Número largo: $numeroLargo")
    println("Letra: $letra")
    println("Número byte: $numeroByte")
    println("Número corto: $numeroCorto")
    println("Pi: $pi")

    println("\n=== VALORES var (mutables) ===")
    println("Ciudad actual: $ciudadActual")
    println("Año actual: $añoActual")
    println("Peso: $peso kg")
    println("Tiene vehículo: $tieneVehiculo")
    println("Promedio: $promedio")
    println("Teléfono: $telefono")
    println("Inicial: $inicial")
    println("Días del mes: $diasMes")
    println("Temperatura: $temperatura°C")
    println("Descuento: $descuento")

    println("\n=== INTERPOLACIÓN DE CADENAS ===")
    val presentacion = "Hola, mi nombre completo es $nombre, tengo $edad años y mido $altura metros. " +
            "Actualmente vivo en $ciudadActual y mi calificación promedio es $promedio (jajaja). " +
            "¿Sabías que el valor de pi es aproximadamente $pi?"
    println(presentacion)

    println("\n=== LLAMADAS A FUNCIONES ===")

    // Función 1: Solo retorna el nombre "KOTLIN"
    println("1. ${obtenerNombreKotlin()}")

    // Función 2: Solicita un parámetro y retorna un saludo
    print("2. Ingresa tu nombre para el saludo: ")
    val nombreUsuario = readLine() ?: "Usuario"
    println("   ${saludar(nombreUsuario)}")

    // Función 3: Solicita 2 parámetros y retorna el resultado de una suma
    println("\n3. === FUNCIÓN SUMA ===")
    val num1 = leerEntero("   Ingresa el primer número: ")
    val num2 = leerEntero("   Ingresa el segundo número: ")
    println("La suma de $num1 + $num2 = ${sumar(num1, num2)}")

    // Función 4: Solicita 2 parámetros y retorna el resultado de una división
    println("\n4. === FUNCIÓN DIVISIÓN ===")
    val dividendo = leerDecimal("   Ingresa el dividendo: ")
    val divisor = leerDecimal("   Ingresa el divisor: ")

    try {
        val resultado = dividir(dividendo, divisor)
        println("La división de $dividendo ÷ $divisor = %.2f".format(resultado))
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    // Función 5: Solicita 3 parámetros y retorna el resultado de una multiplicación
    println("\n5. === FUNCIÓN MULTIPLICACIÓN ===")
    val mult1 = leerEntero("   Ingresa el primer número: ")
    val mult2 = leerEntero("   Ingresa el segundo número: ")
    val mult3 = leerEntero("   Ingresa el tercer número: ")
    println("La multiplicación de $mult1 × $mult2 × $mult3 = ${multiplicar(mult1, mult2, mult3)}")

    println("\n=== MODIFICANDO VARIABLES var ===")
    ciudadActual = "Ciudad de Guatemala"
    peso = 77.0
    tieneVehiculo = true
    println("Ciudad actualizada: $ciudadActual")
    println("Peso actualizado: $peso kg")
    println("Ahora tiene vehículo: $tieneVehiculo")

    println("\n" + "=".repeat(60))
    println("🎉 ¡Programa completado exitosamente!")
    println("Gracias por usar el programa de fundamentos de Kotlin")
    println("=".repeat(60))
}

// Función 1: Solo retorna el nombre "KOTLIN"
fun obtenerNombreKotlin(): String {
    return "KOTLIN"
}

// Función 2: Solicita un parámetro y retorna un saludo junto con el parámetro definido
fun saludar(nombre: String): String {
    return "¡Hola $nombre! Bienvenido al mundo de Kotlin de la mano del Intecap"
}

// Función 3: Solicita 2 parámetros y retorna el resultado de una suma
fun sumar(a: Int, b: Int): Int {
    return a + b
}

// Función 4: Solicita 2 parámetros y retorna el resultado de una división
fun dividir(dividendo: Double, divisor: Double): Double {
    return if (divisor != 0.0) {
        dividendo / divisor
    } else {
        throw IllegalArgumentException("No se puede dividir por cero")
    }
}

// Función 5: Solicita 3 parámetros y retorna el resultado de una multiplicación
fun multiplicar(a: Int, b: Int, c: Int): Int {
    return a * b * c
}

// Función auxiliar para validar entrada de números enteros
fun leerEntero(mensaje: String): Int {
    while (true) {
        print(mensaje)
        val input = readLine()
        val numero = input?.toIntOrNull()
        if (numero != null) {
            return numero
        } else {
            println("Por favor, ingresa un número entero válido.")
        }
    }
}

// Función auxiliar para validar entrada de números decimales
fun leerDecimal(mensaje: String): Double {
    while (true) {
        print(mensaje)
        val input = readLine()
        val numero = input?.toDoubleOrNull()
        if (numero != null) {
            return numero
        } else {
            println("Por favor, ingresa un número decimal válido.")
        }
    }
}