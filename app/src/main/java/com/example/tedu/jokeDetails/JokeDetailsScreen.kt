package com.example.tedu.jokeDetails

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView

class JokeDetailsFragment : Fragment() {
    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val category = arguments?.getString("category") ?: "Unknown"
        val question = arguments?.getString("question") ?: "Unknown"
        val answer = arguments?.getString("answer") ?: "Unknown"

        (view as ComposeView).setContent {
            JokeDetailsScreen(category, question, answer)
        }
    }
}

@Composable
fun JokeDetailsScreen(category: String, question: String, answer: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Категория: $category",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Вопрос: $question",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Ответ: $answer",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
