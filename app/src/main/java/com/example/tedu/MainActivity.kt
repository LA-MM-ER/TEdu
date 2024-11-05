package com.example.tedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    JokesScreen(jokes = getJokesList())
                }
            }
        }
    }

    private fun getJokesList(): List<Joke> {
        return listOf(
            Joke("Штирлиц", "Штирлиц долго смотрел в одну точку. Потом перевел взгляд и посмотрел на другую.", "— Двоеточие!, — догадался Штирлиц."),
            Joke("Животные", "Почему птицы летят на юг?", "Потому что им трудно идти туда пешком"),
            Joke("История", "Кто изобpел полупpоводники?", "Пеpвым полупpоводником был Иван Сусанин."),
            Joke("English", "What does Santa suffer from if he gets stuck in a chimney?", "Claustrophobia!"),
            Joke("Штирлиц", "Штирлиц долго смотрел в одну точку. Потом перевел взгляд и посмотрел на другую.", "— Двоеточие!, — догадался Штирлиц."),
            Joke("Животные", "Почему птицы летят на юг?", "Потому что им трудно идти туда пешком"),
            Joke("История", "Кто изобpел полупpоводники?", "Пеpвым полупpоводником был Иван Сусанин."),
        )
    }
}