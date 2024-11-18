package com.example.tedu

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
        composable("joke_details/{category}/{question}/{answer}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: "Unknown"
            val question = backStackEntry.arguments?.getString("question") ?: "Unknown"
            val answer = backStackEntry.arguments?.getString("answer") ?: "Unknown"
            JokeDetailsScreen(category, question, answer, navController)
        }
    }
}