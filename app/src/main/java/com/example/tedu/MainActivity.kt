package com.example.tedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tedu.jokeDetails.JokeDetailsScreen
import com.example.tedu.jokes.JokesScreen
import com.example.tedu.jokes.JokesViewModel

class MainActivity : ComponentActivity() {

    private val jokeViewModel: JokesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    // Создаем NavController для навигации
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "jokes_screen") {
                        composable("jokes_screen") {
                            JokesScreen(jokes = jokeViewModel.getJokesList(), navController = navController)
                        }
                        composable("joke_details/{category}/{question}/{answer}") { backStackEntry ->
                            val category = backStackEntry.arguments?.getString("category") ?: "Unknown"
                            val question = backStackEntry.arguments?.getString("question") ?: "Unknown"
                            val answer = backStackEntry.arguments?.getString("answer") ?: "Unknown"
                            JokeDetailsScreen(category, question, answer)
                        }
                    }
                }
            }
        }
    }
}
