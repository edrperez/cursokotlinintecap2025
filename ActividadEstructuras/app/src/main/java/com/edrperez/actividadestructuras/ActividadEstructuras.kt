package com.edrperez.actividadestructuras

// ActividadEstructuras
// Proyecto básico con estructuras de control en Kotlin

fun main() {
    println("=== PROGRAMA ACTIVIDAD ESTRUCTURAS ===\n")

    // 1. CONDICIONES IF/ELSE
    println("1. CONDICIONES IF/ELSE")

    // Condición si una persona puede realizar su voto
    val edad = 20
    println("Edad: $edad")
    if (edad >= 18) {
        println("Puede votar")
    } else {
        println("No puede votar")
    }

    // Condiciona y compara 2 números
    val numero1 = 15
    val numero2 = 10
    println("\nComparando $numero1 y $numero2:")
    if (numero1 > numero2) {
        println("$numero1 es mayor que $numero2")
    } else if (numero1 < numero2) {
        println("$numero1 es menor que $numero2")
    } else {
        println("Los números son iguales")
    }

    // Condición si un número es positivo
    val numero = 5
    println("\nNúmero: $numero")
    if (numero > 0) {
        println("El número es positivo")
    } else if (numero < 0) {
        println("El número es negativo")
    } else {
        println("El número es cero")
    }

    // 2. CONDICIÓN WHEN
    println("\n2. CONDICIÓN WHEN")
    println("Clasificación de notas (1 al 10):")

    val nota = 8
    println("Nota: $nota")
    when (nota) {
        in 1..4 -> println("Reprobado")
        in 5..6 -> println("Regular")
        in 7..8 -> println("Bueno")
        in 9..10 -> println("Aprobado")
        else -> println("Nota inválida")
    }

    // 3. CICLO FOR
    println("\n3. CICLO FOR")
    println("Números del 1 al 100:")
    for (i in 1..100) {
        print("$i ")
        if (i % 10 == 0) println() // Nueva línea cada 10 números
    }

    // 4. CICLO WHILE
    println("\n4. CICLO WHILE")
    println("Contador hasta 50:")
    var contador = 1
    while (contador <= 50) {
        print("$contador ")
        if (contador % 10 == 0) println()
        contador++
    }

    // 5. CICLO DO-WHILE
    println("\n5. CICLO DO-WHILE")
    println("5 intentos:")
    var intentos = 1
    do {
        println("Intento número: $intentos")
        intentos++
    } while (intentos <= 5)

    // 6. ARREGLO
    println("\n6. ARREGLO")
    val arreglo = arrayOf(10, 25, 30, 45, 50, 65, 70, 85, 90, 100)
    println("Datos del arreglo:")
    for (i in arreglo.indices) {
        println("Posición $i -> ${arreglo[i]}")
    }

    println()

    // 7. LISTA
    println("\n7. LISTA")
    val lista = listOf("Kotlin", "Java", "Python", "JavaScript", "C++")
    println("Datos de la lista:")
    for (i in lista.indices) {
        println("Índice $i -> ${lista[i]}")
    }

    println()

    println("\n=== FIN DEL PROGRAMA ===")
}