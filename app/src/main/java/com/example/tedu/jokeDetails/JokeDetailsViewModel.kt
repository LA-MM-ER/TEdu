package com.example.tedu.jokeDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class JokeDetailsViewModel(
    initialCategory: String,
    initialQuestion: String,
    initialAnswer: String
) : ViewModel() {

    private val _category = MutableStateFlow(initialCategory)
    val category: StateFlow<String> get() = _category

    private val _question = MutableStateFlow(initialQuestion)
    val question: StateFlow<String> get() = _question

    private val _answer = MutableStateFlow(initialAnswer)
    val answer: StateFlow<String> get() = _answer
}

class JokeDetailsViewModelFactory(
    private val category: String,
    private val question: String,
    private val answer: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JokeDetailsViewModel::class.java)) {
            return JokeDetailsViewModel(category, question, answer) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
