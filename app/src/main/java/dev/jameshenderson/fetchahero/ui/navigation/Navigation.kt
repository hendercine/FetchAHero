package dev.jameshenderson.fetchahero.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.jameshenderson.fetchahero.ui.heroDetails.HeroDetailScreen
import dev.jameshenderson.fetchahero.ui.heroDetails.HeroDetailViewModel
import dev.jameshenderson.fetchahero.ui.heroesList.HeroesListScreen
import dev.jameshenderson.fetchahero.ui.heroesList.HeroesListViewModel

@Composable
fun HeroNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "heroes_list",
    ) {
        composable("heroes_list") {
            val viewModel = hiltViewModel<HeroesListViewModel>()
            HeroesListScreen(viewModel, navController)
        }
        composable(
            "hero_detail/{heroId}",
            arguments = listOf(navArgument("heroId") { type = NavType.IntType }),
        ) {
            val viewModel = hiltViewModel<HeroDetailViewModel>()
            HeroDetailScreen(viewModel) {
                navController.popBackStack()
            }
        }
    }
}
