package com.example.tedu.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tedu.model.Joke
import com.example.tedu.ui.screens.JokeDetailsScreen
import com.example.tedu.ui.screens.JokesScreen
import com.example.tedu.viewmodel.JokesViewModel
import com.example.tedu.ui.screens.NewJokeScreen

@Composable
fun AppNavigation(jokesViewModel: JokesViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "jokes_list"
    ) {
        composable("jokes_list") {
            JokesScreen(jokesViewModel, navController)
        }
        composable("joke_details/{id}/{category}/{question}/{answer}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: "Unknown"
            val category = backStackEntry.arguments?.getString("category") ?: "Unknown"
            val question = backStackEntry.arguments?.getString("question") ?: "Unknown"
            val answer = backStackEntry.arguments?.getString("answer") ?: "Unknown"
            JokeDetailsScreen(id, category, question, answer, navController)
        }

        composable("new_joke") {
            NewJokeScreen(jokesViewModel, navController)
        }
    }
}

fun NavController.navigateToJokeDetails(joke: Joke) {
    this.navigate("joke_details/${joke.id}/${joke.category}/${joke.question}/${joke.answer}")
}
