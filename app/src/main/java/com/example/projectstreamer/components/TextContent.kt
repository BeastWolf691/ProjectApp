package com.example.projectstreamer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextContent(
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val desiredHeight = (screenHeight / 4) // 1/4 eme de l'écran

    Column(
//permet denglober sous format colonne les informations
        modifier = modifier
            .fillMaxWidth()
            .height(desiredHeight)
            .background(Color.LightGray.copy(alpha = 0.4f)) // copy et alpha sont nécessaire pour l'opacité
            .padding(start = 10.dp, top = 5.dp),

        ) {
        Text(
            text = "Star Wars",
            style = TextStyle(fontSize = 35.sp),
        )

        Row {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "",
            )
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "",
            )
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "",
            )
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "",
            )
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "",
            )
        }


        Text(
            text = "Le Lorem Ipsum est simplement du faux texte ".uppercase() +
                    "employé dans la composition et la mise en page ".uppercase() +
                    "avant impression. Le Lorem Ipsum est le faux ".uppercase() +
                    "texte standard de l'imprimerie depuis les années ".uppercase(),
            style = TextStyle(fontSize = 17.sp)
        )
    }
}
