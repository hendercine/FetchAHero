package dev.jameshenderson.fetchahero.data.repositories

import dev.jameshenderson.fetchahero.data.api.MarvelApi
import dev.jameshenderson.fetchahero.data.models.CreatorList
import dev.jameshenderson.fetchahero.data.models.CreatorSummary
import dev.jameshenderson.fetchahero.data.models.DataContainer
import dev.jameshenderson.fetchahero.data.models.Hero
import dev.jameshenderson.fetchahero.data.models.HeroesResponse
import dev.jameshenderson.fetchahero.data.services.MarvelService
import dev.jameshenderson.fetchahero.domain.repositories.HeroRepository
import dev.jameshenderson.fetchahero.utils.BuildConfigUtil
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HeroRepositoryTest {
    private val marvelService = mockk<MarvelService>()
    private val marvelApi = mockk<MarvelApi>()
    private val buildConfigUtil = BuildConfigUtil()
    private val repository = HeroRepository(marvelApi, buildConfigUtil)
    private val expectedListOfHeroes = listOf(
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

    @Before
    fun setup() {
        coEvery { marvelApi.marvelService }.returns(marvelService)
    }

    @Test
    fun `getHeroes returns a list of Hero objects from repository`() = runTest {
        coEvery {
            marvelService.getHeroes(any(), any(), any(), any(), any())
        }.returns(
            HeroesResponse(
                code = 200,
                status = "OK",
                copyright = "Copyright",
                attributionText = "Attribution",
                attributionHTML = "Attribution HTML",
                data = DataContainer(
                    offset = 0,
                    limit = 20,
                    total = 3,
                    count = 3,
                    results = listOf(
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
                )
            )
        )

        val expected = expectedListOfHeroes
        val result = repository.getHeroes()

        Assert.assertEquals(expected, result)
    }

    @Test
    fun `getHeroDetails returns a Hero object from repository`() = runTest {
        coEvery {
            marvelService.getHeroDetails(any(), any(), any(), any())
        }.returns(
            HeroesResponse(
                code = 200,
                status = "OK",
                copyright = "Copyright",
                attributionText = "Attribution",
                attributionHTML = "Attribution HTML",
                data = DataContainer(
                    offset = 0,
                    limit = 20,
                    total = 3,
                    count = 3,
                    results = listOf(
                        Hero(
                            id = 1,
                            title = "Fake Hero 1",
                            description = "Description 1",
                        )
                    )
                )
            )
        )
        val expected = Hero(
            id = 1,
            title = "Fake Hero 1",
            description = "Description 1",
        )
        val result = repository.getHeroDetails(1)
        Assert.assertEquals(expected, result)
    }
}
