package dev.jameshenderson.fetchahero.domain.useCases

import dev.jameshenderson.fetchahero.data.models.Hero
import dev.jameshenderson.fetchahero.domain.repositories.HeroRepositoryInterface
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetHeroesUseCase @Inject constructor(
    private val heroRepository: HeroRepositoryInterface
) : UseCase<Unit, Result<List<Hero>>> {
    override suspend operator fun invoke(params: Unit): Result<List<Hero>> {
        return try {
            val comicBooks = heroRepository.getHeroes()
            Result.success(comicBooks)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
