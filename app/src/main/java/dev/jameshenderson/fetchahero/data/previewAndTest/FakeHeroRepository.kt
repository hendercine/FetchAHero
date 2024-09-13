package dev.jameshenderson.fetchahero.data.previewAndTest

import dev.jameshenderson.fetchahero.data.models.CreatorList
import dev.jameshenderson.fetchahero.data.models.CreatorSummary
import dev.jameshenderson.fetchahero.data.models.Hero
import dev.jameshenderson.fetchahero.domain.repositories.HeroRepositoryInterface

class FakeHeroRepository : HeroRepositoryInterface {
    override suspend fun getHeroes(): List<Hero> = listOf(
        Hero(
            id = 1,
            title = "Fake Hero 1",
            description = "Description 1",
            creators = CreatorList(
                items = listOf(
                    CreatorSummary(
                        name = "Stan Lee"
                    ),
                    CreatorSummary(
                        name = "Len Wein"
                    ),
                    CreatorSummary(
                        name = "Steve Ditko"
                    )
                )
            )
        ),
        Hero(
            id = 2,
            title = "Fake Hero 2",
            description = "Description 2",
            creators = CreatorList(
                items = listOf(
                    CreatorSummary(
                        name = "Jim Lee"
                    ),
                    CreatorSummary(
                        name = "Jack Kirby"
                    ),
                    CreatorSummary(
                        name = "Al Ewing"
                    )
                )
            )
        ),
        Hero(
            id = 3,
            title = "Fake Hero 3",
            description = "Description 3",
            creators = CreatorList(
                items = listOf(
                    CreatorSummary(
                        name = "Gerry Duggan"
                    ),
                    CreatorSummary(
                        name = "Donny Cates"
                    ),
                    CreatorSummary(
                        name = "Frank Miller"
                    )
                )
            )
        ),
    )

    override suspend fun getHeroDetails(heroId: Int): Hero {
        return Hero(
            id = heroId,
            title = "Fake Hero $heroId",
            description = "Description $heroId",
            creators = CreatorList(
                items = listOf(
                    CreatorSummary(
                        name = "Stan Lee"
                    ),
                    CreatorSummary(
                        name = "Len Wein"
                    )
                )
            )
        )
    }
}
