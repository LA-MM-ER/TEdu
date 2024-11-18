package com.example.tedu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class JokesViewModel : ViewModel() {
    private val _jokesList = MutableStateFlow<List<Joke>>(emptyList())
    val jokesList = _jokesList.asStateFlow()

    init {
        loadJokes()
    }

    private fun loadJokes() {
        viewModelScope.launch {
            delay(1000) //фейк прогрузка
            _jokesList.value = listOf(
                Joke(1.toString(), "Штирлиц", "Штирлиц долго смотрел в одну точку. Потом перевел взгляд и посмотрел на другую.", "— Двоеточие!, — догадался Штирлиц."),
                Joke(2.toString(),"Животные", "Почему птицы летят на юг?", "Потому что им трудно идти туда пешком"),
                Joke(3.toString(),"История", "Кто изобpел полупpоводники?", "Пеpвым полупpоводником был Иван Сусанин."),
                Joke(4.toString(),"English", "What does Santa suffer from if he gets stuck in a chimney?", "Claustrophobia!"),
                Joke(5.toString(),"Штирлиц", "Штирлиц долго смотрел в одну точку. Потом перевел взгляд и посмотрел на другую.", "— Двоеточие!, — догадался Штирлиц."),
                Joke(6.toString(),"Животные", "Почему птицы летят на юг?", "Потому что им трудно идти туда пешком"),
                Joke(7.toString(),"История", "Кто изобpел полупpоводники?", "Пеpвым полупpоводником был Иван Сусанин."),
                Joke(8.toString(),"История", "Кто изобpел полупpоводники?", "Пеpвым полупpоводником был Иван Сусанин."),
            )
        }
    }

    fun addJoke(category: String, question: String, answer: String) {
        val newJoke = Joke(UUID.randomUUID().toString(), category, question, answer)
        _jokesList.value += newJoke
    }
}
