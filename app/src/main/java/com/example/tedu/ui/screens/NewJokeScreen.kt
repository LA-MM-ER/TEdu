package com.example.tedu.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tedu.viewmodel.JokesViewModel
import com.example.tedu.R

@Composable
fun NewJokeScreen(jokesViewModel: JokesViewModel, navController: NavController) {
    var category by remember { mutableStateOf("") }
    var question by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TextField(
                value = category,
                onValueChange = { category = it },
                label = { Text(stringResource(R.string.joke_category)) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = question,
                onValueChange = { question = it },
                label = { Text(stringResource(R.string.joke_question)) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = answer,
                onValueChange = { answer = it },
                label = { Text(stringResource(R.string.joke_answer)) },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Кнопка закреплена внизу
        Button(
            onClick = {
                jokesViewModel.addJoke(category, question, answer)
                navController.popBackStack()
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text(stringResource(R.string.joke_add_button))
        }
    }
}

