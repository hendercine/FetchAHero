package dev.jameshenderson.fetchahero.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dev.jameshenderson.fetchahero.ui.navigation.HeroNavigation

@Composable
fun HeroesApp() {
    val navController = rememberNavController()
    HeroNavigation(navController)
}
