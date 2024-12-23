package com.example.tedu.model

data class Joke(
    val id: String,
    val category: String,
    val question: String,
    val answer: String,
    val source: JokeSource
)

enum class JokeSource {
    LOCAL, NETWORK
}
