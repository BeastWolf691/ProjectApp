package com.example.projectstreamer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.projectstreamer.ui.theme.ProjectStreamerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectStreamerTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    containerColor = Color(0xFFD2D5D6)
                ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),

                        )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,

    ) {
    // Définir la largeur et la hauteur souhaitées pour le header
    val headerWidth = 350.dp
    val headerHeight = 80.dp


    Box(
        modifier = modifier
            .padding()
            .height(headerHeight)
            .background(Color.White)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize() // Remplir tout le header
        ) {
            // Icône avec un espace
            Icon(imageVector = Icons.Filled.DateRange, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp) .padding(top = 25.dp)) // Ajoute un espace entre le texte et l'icône


            // Icône avec un espace
            Spacer(modifier = Modifier.width(10.dp)) // Ajoute un espace entre le texte et l'icône
            SearchBar(query = "", onQueryChange = {}, onSearch = {}, active = true, onActiveChange = {}) {

            }

            // Texte avec padding
            Text(
                text = "entre copain copine $name!",
                modifier = Modifier.weight(1f) // Utilise le reste de l'espace disponible
            )


        }
    }
}
