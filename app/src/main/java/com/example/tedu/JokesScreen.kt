package com.example.tedu

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun JokesScreen(jokesViewModel: JokesViewModel, navController: NavController) {
    val jokes = jokesViewModel.getJokesList()

    Column(modifier = Modifier.fillMaxSize()) {
        jokes.forEach { joke ->
            JokeItem(joke = joke, navController = navController)
        }
    }
}
