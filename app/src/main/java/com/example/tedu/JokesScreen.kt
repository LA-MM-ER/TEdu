package com.example.tedu

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun JokesScreen(jokes: List<Joke>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize() //фикс черного прямоугольника внизу
    ) {
        items(jokes.size) { index ->
            JokeItem(joke = jokes[index])
        }
    }
}