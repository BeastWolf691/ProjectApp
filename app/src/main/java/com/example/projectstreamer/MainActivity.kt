package com.example.projectstreamer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.projectstreamer.components.Footer
import com.example.projectstreamer.components.Header
import com.example.projectstreamer.components.TextContent
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
                ) { innerPadding ->
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // Image en arrière-plan
                        Image(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillHeight//permet de définir la taille de l'image background
                        )
                        Column(
                            modifier = Modifier.padding(innerPadding),
                            verticalArrangement = Arrangement.Top,
                        ) {
                            Header()

                            Spacer(modifier = Modifier.weight(0.5f)) // espace entre les parties

                            TextContent()

                            Spacer(modifier = Modifier.weight(0.4f)) // espace entre les parties

                            Footer()

                        }
                    }
                }
            }
        }
    }

}




