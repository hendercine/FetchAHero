package dev.jameshenderson.fetchahero.ui.heroDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.jameshenderson.fetchahero.data.models.Hero
import dev.jameshenderson.fetchahero.domain.useCases.GetHeroDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel
    @Inject
    constructor(
        getHeroDetailsUseCase: GetHeroDetailsUseCase,
        savedStateHandle: SavedStateHandle,
    ) : ViewModel() {
        private val _hero = MutableStateFlow<Hero?>(null)
        val heroStateFlow: StateFlow<Hero?>
            get() = _hero

        init {
            viewModelScope.launch {
                val heroId = savedStateHandle.get<Int>("heroId") ?: throw Exception("Comic book ID not found")
                val result = getHeroDetailsUseCase.invoke(heroId)
                result
                    .onSuccess { hero ->
                        _hero.value = hero
                    }.onFailure {
                        // Handle error
                        it.printStackTrace()
                    }
            }
        }
    }
