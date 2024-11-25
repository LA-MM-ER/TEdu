package com.example.tedu.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tedu.ui.screens.components.JokeItem
import com.example.tedu.viewmodel.JokesViewModel
import com.example.tedu.R

@Composable
fun JokesScreen(jokesViewModel: JokesViewModel, navController: NavController) {
    val jokesList by jokesViewModel.jokesList.collectAsState()
    val isLoading by jokesViewModel.isLoading.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        val state = rememberLazyListState()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 72.dp), // Отступ для кнопки
            state = state,
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(jokesList) { joke ->
                JokeItem(joke, navController)
            }

            // Элемент для индикации загрузки при пагинации
            item {
                if (isLoading) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }

        // Подгружаем следующие шутки при достижении конца списка
        LaunchedEffect(state) {
            snapshotFlow { state.layoutInfo.visibleItemsInfo.lastOrNull() }
                .collect { visibleItem ->
                    val lastItemIndex = visibleItem?.index ?: 0
                    if (lastItemIndex == jokesList.size - 1) {
                        jokesViewModel.fetchNetworkJokes() // Загружаем новые шутки
                    }
                }
        }

        // Кнопка добавления собственной шутки
        Button(
            onClick = { navController.navigate("new_joke") },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text(text = stringResource(R.string.joke_add_button))
        }
    }
}




