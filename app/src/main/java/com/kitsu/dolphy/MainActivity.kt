package com.kitsu.dolphy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kitsu.dolphy.ui.theme.KitsuDolphyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KitsuDolphyTheme(darkTheme = true) {
                HomeScreen()
            }
        }
    }
}

@Composable
private fun HomeScreen() {
    Scaffold { paddingValues ->
        Text(
            text = "Kitsu-Dolphy",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
        )
    }
}
