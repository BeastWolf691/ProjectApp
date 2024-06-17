package com.example.projectstreamer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Header(name = "Android")

                        Spacer(modifier = Modifier.height(200.dp)) // espace entre les parties

                        TextContent(name = "Android")

                        Spacer(modifier = Modifier.height(150.dp)) // espace entre les parties

                        Footer()

                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    name: String,
    modifier: Modifier = Modifier,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val desiredHeight = (screenHeight / 10) // 1/10 de la hauteur de l'écran


    Box(
        modifier = modifier
            .height(desiredHeight)
            .background(Color.Transparent)
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp), // ajouter un padding horizontal
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Ajout de Arrangement.SpaceBetween pour la répartition de l'espace
        ) {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "",
            )

            Spacer(modifier = Modifier.width(30.dp)) // Ajoute un espace entre l'icône et la barre de recherche

            SearchBar(
                query = "",
                onQueryChange = {},
                onSearch = {},
                active = true,
                onActiveChange = {},
            ) {

            }

        }
    }
}

@Composable
fun TextContent(
    name: String,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val desiredHeight = (screenHeight / 4) // 1/4 eme de l'écran

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(desiredHeight)
            .background(Color.Yellow)
            .padding(horizontal = 16.dp), // ajuste l'emplacement du texte
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Gloire a Cthulhu le grand, l'être suprême",
            style = TextStyle(fontSize = 25.sp)
        )
    }
}

@Composable
fun Footer(
    modifier: Modifier = Modifier,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val desiredHeight = (screenHeight / 5) // 1/5s de la hauteur de l'écran

}

