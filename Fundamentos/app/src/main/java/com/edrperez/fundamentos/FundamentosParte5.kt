package com.edrperez.fundamentos

fun main(){
    condicionesIfElse()
    condicionesIfElse2(3,2)
    condicionesIfElseAnidados()
}

private fun condicionesIfElse(){
    //Condición para obtener mi DPI
    val edadActual: Int = 19
    val edadParaDPI: Int = 18
    if (edadActual >= edadParaDPI){
        println("Ya puedes obtener tu DPI")
    } else {
        println("Tienen que esperar para tu DPI porque aun tienes $edadActual")
    }
}
fun condicionesIfElse2(numero1:Int, numero2:Int){
    //Comparar 2 numeros
    if (numero1 > numero2){
        println("$numero1 es mayor a $numero2")
    } else if (numero1 == numero2){
        println("Ambos numeros son iguales")
    } else {
        println("$numero2 es mayor a $numero1")
    }
}

fun condicionesIfElseAnidados(){
    val pase1: Boolean = true
    val pase2: Boolean = true
    val codigo: Int = 123456

    if (pase1 == true and pase2 == true) {
        if (codigo == 123456) {
            println("Bienvenido")
        } else {
            println("Codigo incorrecto")
        }
    } else {
        println("No tenes un pase")
    }
}