package com.example.tedu.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tedu.model.Joke
import com.example.tedu.model.JokeSource
import com.example.tedu.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID


class JokesViewModel : ViewModel() {
    private val _jokesList = MutableStateFlow<List<Joke>>(emptyList())
    val jokesList = _jokesList.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val jokesPerPage = 10

    init {
        loadLocalJokes()
        fetchNetworkJokes()
    }

    private fun loadLocalJokes() {
        _jokesList.value = listOf(
            Joke(1.toString(), "Штирлиц", "Штирлиц долго смотрел в одну точку. Потом перевел взгляд и посмотрел на другую.", "— Двоеточие!, — догадался Штирлиц.", JokeSource.LOCAL),
            Joke(2.toString(),"Животные", "Почему птицы летят на юг?", "Потому что им трудно идти туда пешком", JokeSource.LOCAL),
            Joke(3.toString(),"История", "Кто изобpел полупpоводники?", "Пеpвым полупpоводником был Иван Сусанин.", JokeSource.LOCAL),
            Joke(4.toString(),"English", "What does Santa suffer from if he gets stuck in a chimney?", "Claustrophobia!", JokeSource.LOCAL),
            Joke(5.toString(),"Штирлиц", "Штирлиц долго смотрел в одну точку. Потом перевел взгляд и посмотрел на другую.", "— Двоеточие!, — догадался Штирлиц.", JokeSource.LOCAL),
            Joke(6.toString(),"Животные", "Почему птицы летят на юг?", "Потому что им трудно идти туда пешком", JokeSource.LOCAL),
            Joke(7.toString(),"История", "Кто изобpел полупpоводники?", "Пеpвым полупpоводником был Иван Сусанин.", JokeSource.LOCAL),
            Joke(8.toString(),"История", "Кто изобpел полупpоводники?", "Пеpвым полупpоводником был Иван Сусанин.", JokeSource.LOCAL),
        )
    }

    fun fetchNetworkJokes() {
        if (_isLoading.value) return // если уже идет загрузка, не делать запрос

        viewModelScope.launch {
            _isLoading.value = true // Показываем индикатор загрузки
            try {
                val response = RetrofitInstance.api.fetchJokes(amount = jokesPerPage)

                // Преобразуем NetworkJoke в Joke с указанием источника
                val networkJokes = response.jokes.map { networkJoke ->
                    Joke(
                        id = networkJoke.id,
                        category = networkJoke.category,
                        question = networkJoke.setup,
                        answer = networkJoke.delivery,
                        source = JokeSource.NETWORK
                    )
                }

                // Добавляем новые шутки в общий список
                _jokesList.value += networkJokes
            } catch (e: Exception) {
                Log.e("JokesViewModel", "Ошибка загрузки шуток: ${e.message}")
            } finally {
                _isLoading.value = false // Скрываем индикатор загрузки
            }
        }
    }

    fun addJoke(category: String, question: String, answer: String) {
        val newJoke = Joke(UUID.randomUUID().toString(), category, question, answer, JokeSource.LOCAL)
        _jokesList.value += newJoke
    }
}


