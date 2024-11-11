package com.example.tedu.jokeDetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.tedu.Joke

class JokeDetailsActivity : ComponentActivity() {

    companion object {
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
    }

    private val viewModel: JokeDetailsViewModel by viewModels {
        JokeDetailsViewModelFactory(
            intent.getStringExtra(CATEGORY_KEY) ?: "Unknown",
            intent.getStringExtra(QUESTION_KEY) ?: "Unknown",
            intent.getStringExtra(ANSWER_KEY) ?: "Unknown"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val category by viewModel.category.collectAsState()
            val question by viewModel.question.collectAsState()
            val answer by viewModel.answer.collectAsState()

            MaterialTheme {
                Surface {
                    JokeDetailsScreen(category, question, answer)
                }
            }
        }
    }
}
