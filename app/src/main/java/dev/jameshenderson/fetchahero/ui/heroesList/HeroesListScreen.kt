package dev.jameshenderson.fetchahero.ui.heroesList

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import dev.jameshenderson.fetchahero.data.previewAndTest.FakeHeroRepository
import dev.jameshenderson.fetchahero.domain.useCases.GetHeroesUseCase
import dev.jameshenderson.fetchahero.ui.components.HeroUIComponent
import dev.jameshenderson.fetchahero.ui.heroDetails.HeroDetailScreen
import dev.jameshenderson.fetchahero.ui.heroDetails.HeroDetailViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesListScreen(
    viewModel: HeroesListViewModel,
    navController: NavController,
) {
    val heroes = viewModel.heroesStateFlow.collectAsState()
    Scaffold(
        topBar = { TopAppBar(title = { Text("Fetch A Hero") }) },
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(heroes.value.size) { index ->
                val hero = heroes.value[index]
                HeroUIComponent(hero) {
                    navController.navigate(
                        "hero_detail/${hero.id}",
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HeroesListScreenPreview() {
    HeroesListScreen(
        viewModel = HeroesListViewModel(
            getHeroesUseCase = GetHeroesUseCase(FakeHeroRepository()),
        ),
        navController = NavController(LocalContext.current)
    )
}
