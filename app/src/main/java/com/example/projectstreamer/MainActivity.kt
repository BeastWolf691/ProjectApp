package com.example.projectstreamer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
                        .fillMaxSize()
                        .background(Color.LightGray) // Couleur de fond pour tout le corps
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, backgroundColor: Color = Color.LightGray) {
    // Définir la largeur et la hauteur souhaitées pour le header
    val headerWidth = 350.dp
    val headerHeight = 80.dp


    Box(
        modifier = modifier
            .padding(start = 15.dp, top = 15.dp)
            .width(headerWidth)
            .height(headerHeight)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize() // Remplir tout le header
        ) {
            // Icône avec un espace
            Icon(imageVector = Icons.Filled.DateRange, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp)) // Ajoute un espace entre le texte et l'icône

            // Texte avec padding
            Text(
                text = "entre copain copine $name!",
                modifier = Modifier.weight(1f) // Utilise le reste de l'espace disponible
            )

            // Icône avec un espace
            Spacer(modifier = Modifier.width(10.dp)) // Ajoute un espace entre le texte et l'icône
            Icon(imageVector = Icons.Filled.Create, contentDescription = "")
        }
    }
}
