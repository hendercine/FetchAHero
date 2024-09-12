package dev.jameshenderson.fetchahero.domain.useCases

import dev.jameshenderson.fetchahero.data.models.Hero
import dev.jameshenderson.fetchahero.domain.repositories.HeroRepositoryInterface
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetHeroDetailsUseCase @Inject constructor(
    private val heroRepository: HeroRepositoryInterface
): UseCase<Int, Result<Hero>> {
    override suspend fun invoke(params: Int): Result<Hero> {
        return try {
            val hero = heroRepository.getHeroDetails(params)
            Result.success(hero)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
