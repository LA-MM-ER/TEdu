package com.example.tedu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

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
                label = { Text("Категория") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = question,
                onValueChange = { question = it },
                label = { Text("Вопрос") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = answer,
                onValueChange = { answer = it },
                label = { Text("Ответ") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Кнопка закреплена внизу
        Button(
            onClick = {
                jokesViewModel.addJoke(category, question, answer)
                navController.popBackStack() // Navigate back to the main screen
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text("Добавить шутку")
        }
    }
}

