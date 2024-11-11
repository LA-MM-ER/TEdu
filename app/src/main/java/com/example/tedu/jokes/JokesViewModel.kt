package com.example.tedu.jokes

import androidx.lifecycle.ViewModel
import com.example.tedu.Joke

class JokesViewModel : ViewModel() {

    fun getJokesList(): List<Joke> {
        return listOf(
            Joke("Штирлиц", "Штирлиц долго смотрел в одну точку. Потом перевел взгляд и посмотрел на другую.", "— Двоеточие!, — догадался Штирлиц."),
            Joke("Животные", "Почему птицы летят на юг?", "Потому что им трудно идти туда пешком"),
            Joke("История", "Кто изобpел полупpоводники?", "Пеpвым полупpоводником был Иван Сусанин."),
            Joke("English", "What does Santa suffer from if he gets stuck in a chimney?", "Claustrophobia!"),
            Joke("Штирлиц", "Штирлиц долго смотрел в одну точку. Потом перевел взгляд и посмотрел на другую.", "— Двоеточие!, — догадался Штирлиц."),
            Joke("Животные", "Почему птицы летят на юг?", "Потому что им трудно идти туда пешком"),
            Joke("История", "Кто изобpел полупpоводники?", "Пеpвым полупpоводником был Иван Сусанин.")
        )
    }
}