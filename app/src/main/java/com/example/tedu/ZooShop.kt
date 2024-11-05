package com.example.tedu

interface Animal {
    var weight: Int
    var age: Int
}

interface Dog : Animal {
    var biteType: String
}

interface Cat : Animal {
    var behaviorType: String
}

class Husky(override var weight: Int, override var age: Int, override var biteType: String) : Dog

class Corgi(override var weight: Int, override var age: Int, override var biteType: String) : Dog

class ScottishCat(override var weight: Int, override var age: Int, override var behaviorType: String) : Cat

class SiameseCat(override var weight: Int, override var age: Int, override var behaviorType: String) : Cat

class ZooShop {
    fun identifyAnimal(animal: Animal): String {
        return when (animal) {
            is Dog -> "This is a dog"
            is Cat -> "This is a cat"
            else -> "Unknown animal"
        }
    }
}

fun main() {
    val husky = Husky(20, 3, "straight")
    val corgi = Corgi(12, 2, "overbite")
    val scottishCat = ScottishCat(5, 4, "passive")
    val siameseCat = SiameseCat(4, 2, "active")

    val shop = ZooShop()

    println(shop.identifyAnimal(husky))
    println(shop.identifyAnimal(corgi))
    println(shop.identifyAnimal(scottishCat))
    println(shop.identifyAnimal(siameseCat))
}
