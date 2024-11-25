package com.example.tedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.tedu.ui.navigation.AppNavigation
import com.example.tedu.viewmodel.JokesViewModel

class MainActivity : ComponentActivity() {
    private val jokesViewModel: JokesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    AppNavigation(jokesViewModel)
                }
            }
        }
    }
}