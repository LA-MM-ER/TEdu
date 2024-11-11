package com.example.tedu.jokes

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.tedu.Joke

class JokesFragment : Fragment() {

    private lateinit var viewModel: JokesViewModel

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализируем ViewModel
        viewModel = ViewModelProvider(this)[JokesViewModel::class.java]

        val navController = findNavController()

        (view as ComposeView).setContent {
            val jokes = viewModel.getJokesList()
            JokesScreen(jokes = jokes, navController = navController)
        }
    }
}

@Composable
fun JokesScreen(jokes: List<Joke>, navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(jokes.size) { index ->
            JokeItem(joke = jokes[index])
        }
    }
}
