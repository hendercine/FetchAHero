package dev.jameshenderson.fetchahero.ui.heroesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.jameshenderson.fetchahero.data.models.Hero
import dev.jameshenderson.fetchahero.domain.useCases.GetHeroesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesListViewModel @Inject constructor(
    private val getHeroesUseCase: GetHeroesUseCase
) : ViewModel() {
    private val _heroes = MutableStateFlow<List<Hero>>(emptyList())
    val heroesStateFlow: StateFlow<List<Hero>> = _heroes

    init {
        viewModelScope.launch {
            val result = getHeroesUseCase.invoke(Unit)
            result.onSuccess { heroes ->
                _heroes.value = heroes
            }.onFailure { exception ->
                // Handle error
                exception.printStackTrace()
            }
        }
    }
}