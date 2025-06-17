package com.edrperez.fundamentos

fun main() {
    condicionConWhen1()
    condicionConWhen2(11)
    if(condicionConWhen3() == 1){
        println("Es una unidad")
    } else if (condicionConWhen3() == 10){
        println("Es una decena")
    } else if (condicionConWhen3() == 100){
        println("Es una centena")
    } else {
        println("No hay informacion")
    }
}

fun condicionConWhen1(){
    val dia = 11
    when(dia){
        1 -> println("Lunes")
        2 -> println("Martes")
        3 -> println("Miercoles")
        4 -> println("Jueves")
        5 -> println("Viernes")
        6 -> println("Sabado")
        7 -> println("Domingo")
        else -> println("Numero de dia no correcto")
    }
}

fun condicionConWhen2(nota:Int?){
    //Analizar la nota de un estudiante
    if(nota == null) {
        println("Por favor ingresa una nota")
    } else {
        val resultado = when(nota) {
            in 0 .. 5 -> "Reprobado"
            6,7 -> "Regular"
            8,9 -> "Bueno"
            10 -> "Excelente"
            else -> "Nota invalida"
        }
        println(resultado)
    }
}

fun condicionConWhen3(): Int{
    //REconocer unidades decenas y centenas
    val x = 1
    val retorno = when(x){
        in 0 .. 9 -> 1
        in 10 .. 99 -> 10
        in 100 .. 999 -> 100
        else -> 0
    }
    return retorno
}
