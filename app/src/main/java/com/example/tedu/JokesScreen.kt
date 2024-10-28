package com.example.tedu

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun JokesScreen(jokes: List<Joke>) {
    LazyColumn {
        items(jokes.size) { index ->
            JokeItem(joke = jokes[index])
        }
    }
}