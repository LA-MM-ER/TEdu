package com.example.tedu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// определим ключи
const val CATEGORY_KEY = "category"
const val QUESTION_KEY = "question"
const val ANSWER_KEY = "answer"

fun createJokeDetailsIntent(context: Context, joke: Joke): Intent {
    return Intent(context, JokeDetailsActivity::class.java).apply {
        putExtra(CATEGORY_KEY, joke.category)
        putExtra(QUESTION_KEY, joke.question)
        putExtra(ANSWER_KEY, joke.answer)
    }
}

class JokeDetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val category = intent.getStringExtra(CATEGORY_KEY) ?: "Unknown"
        val question = intent.getStringExtra(QUESTION_KEY) ?: "Unknown"
        val answer = intent.getStringExtra(ANSWER_KEY) ?: "Unknown"

        setContent {
            MaterialTheme {
                Surface {
                    JokeDetailsScreen(category, question, answer)
                }
            }
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
