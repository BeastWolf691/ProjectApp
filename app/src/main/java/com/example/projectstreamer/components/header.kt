package com.example.projectstreamer.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun Header(
    modifier: Modifier = Modifier,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val desiredHeight = (screenHeight / 10) // 1/10 de la hauteur de l'écran
    var query by remember { mutableStateOf("") }//permet de faire la liaison pour afficher le texte saisie dans textfield

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
                tint = Color.White,
            )

            Spacer(modifier = Modifier.width(30.dp)) // Ajoute un espace entre l'icône et la barre de recherche

            TextField(
                value = query,
                onValueChange = { query = it },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0x60FFFFFF),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier
                    .border(width = 0.dp, color = Color.Transparent)
                    .weight(5f)
                    .clip(RoundedCornerShape(100))
            )
        }

    }
}