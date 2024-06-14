// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    //Implémentation de Material Design 3
    ( "androidx.compose.material3:material3:1.1.2" )
}