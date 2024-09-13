package dev.jameshenderson.fetchahero.ui.heroDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.jameshenderson.fetchahero.data.previewAndTest.FakeHeroRepository
import dev.jameshenderson.fetchahero.domain.useCases.GetHeroDetailsUseCase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroDetailScreen(
    viewModel: HeroDetailViewModel,
    navigateBack: () -> Unit = {},
) {
    val hero = viewModel.heroStateFlow.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = hero.value?.title ?: "Hero Details",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navigateBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description",
                        )
                    }
                },
            )
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                if (hero.value != null) {
                    Column(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                                .align(Alignment.CenterHorizontally),
                    ) {
                        val imageUrl =
                            "${hero.value!!.thumbnail?.path}.${hero.value!!
                                .thumbnail?.extension}".replace("http", "https")
                        AsyncImage(
                            model =
                                ImageRequest
                                    .Builder(LocalContext.current)
                                    .data(imageUrl)
                                    .crossfade(true)
                                    .build(),
                            contentDescription = "Hero Cover Thumbnail",
                            modifier =
                                Modifier
                                    .padding(end = 8.dp),
                        )
                    }
                    Row {
                        Text(
                            text = hero.value!!.description ?: "Description not found",
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }

                    hero.value!!.creators?.items?.forEach {
                        Row {
                            Text(
                                text = "${it.role}: ",
                                style = MaterialTheme.typography.bodyMedium,
                            )
                            Text(
                                text = "${it.name}",
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        }
                    }
                } else {
                    Text(text = "Hero not found")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroDetailScreenPreview() {
    HeroDetailScreen(
        viewModel = HeroDetailViewModel(
            getHeroDetailsUseCase = GetHeroDetailsUseCase(FakeHeroRepository()),
            savedStateHandle = SavedStateHandle().apply {
                set("heroId", 1)
            }
        ),
    )
}
