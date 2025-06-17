package com.edrperez.fundamentos

fun main(){
// esto es un comentario
    /*más comentarios en
    * más de una línea*/
    //Declaración de val y var
    //Declaración sin tipado
    val nombreAnimal = "perro"
    var edadAnimal = 3

    //Declaración con tipado
    val peso:Double = 3.5
    var tamano = 1.5f
    var razaAnimal:Char = 'A'

    //Diferencia entre var y val
    //nombreAnimal = "gato" //no es posible reasignar un valor, es una constante
    edadAnimal = 5 //es mutable, una variable normal

    println(10)
    println(nombreAnimal)
    println(edadAnimal)
    println(peso)
    println(tamano)
    println(razaAnimal)
}