package com.example.projectstreamer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectstreamer.ui.theme.ProjectStreamerTheme
import org.w3c.dom.Text

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
    val desiredHeight = (screenHeight / 5) // 1/5 eme de l'écran

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(desiredHeight)
            .background(Color.Transparent)
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
    val desiredHeight = (screenHeight / 4) // 1/4 de la hauteur de l'écran

    Column(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(max = desiredHeight)
            .background(Color.Gray) // Couleur de fond du footer
            .padding(16.dp), // Ajustement du padding global du footer
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Liste de données pour les images et les phrases et ainsi avoir le footer souhaité
        val imagesWithTexts = listOf(
            ImageWithText(
                imageResId = "" ,
                text = "Phrase pour image 1"
            ),
            ImageWithText(
                imageResId = "",
                text = "Phrase pour image 2"
            ),
            ImageWithText(
                imageResId = "",
                text = "Phrase pour image 3"
            ),
            ImageWithText(
                imageResId = "",
                text = "Phrase pour image 4"
            )
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(imagesWithTexts.chunked(2)) { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowItems.forEach { item ->
                        ImageWithTextComponent(
                            imageResId = item.imageResId,
                            text = item.text
                        )
                    }
                }
            }
        }
    }
}

// Modèle de données pour une image avec un texte associé
data class ImageWithText(
    val imageResId: Int,
    val text: String
)

@Composable
fun ImageWithTextComponent(imageResId: Int, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Image(
            painter = painterResource(imageResId),
            contentDescription = null, // La description de contenu peut être null pour les images décoratives
            modifier = Modifier.size(100.dp) // Taille de l'image, ajustez selon vos besoins
        )
        Text(
            text = text,
            fontSize = 16.sp, // Taille du texte, ajustez selon vos besoins
            modifier = Modifier.padding(top = 8.dp) // Espace entre l'image et le texte
        )
    }
}