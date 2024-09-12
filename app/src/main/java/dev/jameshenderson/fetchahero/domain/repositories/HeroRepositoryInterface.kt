package dev.jameshenderson.fetchahero.domain.repositories

import dev.jameshenderson.fetchahero.data.models.Hero

interface HeroRepositoryInterface {
    suspend fun getHeroes(): List<Hero>

    suspend fun getHeroDetails(comicId: Int): Hero
}
