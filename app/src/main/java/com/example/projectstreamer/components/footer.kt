package com.example.projectstreamer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectstreamer.R

@Composable
fun Footer(
    modifier: Modifier = Modifier,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val desiredHeight = (screenHeight / 5) // 1/5 de la hauteur de l'écran

    Column(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(max = desiredHeight)
            .background(Color.LightGray.copy(alpha = 0.4f)) // copy et alpha sont nécessaire pour l'opacité // Couleur de fond du footer
            .padding(16.dp), // Ajustement du padding global du footer

    ) {
        // Liste de données pour les images et les phrases
        val scrollState = rememberScrollState()
        val imagesWithTexts = listOf(
            ImageWithText(
                imageResId = R.drawable.image1,//indique le chemin
                text = "Star Wars"
            ),
            ImageWithText(
                imageResId = R.drawable.image2,
                text = "Stormtrooper"
            ),
            ImageWithText(
                imageResId = R.drawable.image3,
                text = "Je suis ton père"
            ),
            ImageWithText(
                imageResId = R.drawable.image4,
                text = "Ah Nan"
            )
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(imagesWithTexts.chunked(4)) { rowItems ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(state = scrollState),
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

fun items(chunked: List<List<ImageWithText>>, any: Any) {
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
            modifier = Modifier
                .width(100.dp)
                .height(90.dp)// Taille de l'image
        )
        Text(
            text = text,
            fontSize = 17.sp, // Taille du texte
            modifier = Modifier.padding(top = 0.dp) // Espace entre l'image et le texte
        )
    }
}
