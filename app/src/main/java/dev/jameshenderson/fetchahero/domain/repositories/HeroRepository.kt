package dev.jameshenderson.fetchahero.domain.repositories

import dev.jameshenderson.fetchahero.data.api.MarvelApi
import dev.jameshenderson.fetchahero.data.models.Hero
import dev.jameshenderson.fetchahero.extensions.md5
import dev.jameshenderson.fetchahero.utils.BuildConfigUtil
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class HeroRepository @Inject constructor(
    private val marvelApi: MarvelApi,
    buildConfigUtil: BuildConfigUtil
) : HeroRepositoryInterface {
    private val publicKey =  buildConfigUtil.getPublicApiKey() ?: ""
    private val privateKey = buildConfigUtil.getPrivateApiKey() ?: ""
    private val timestamp = (System.currentTimeMillis() / 1000).toString()
    private val hash = "$timestamp$privateKey$publicKey".md5()

    override suspend fun getHeroes(): List<Hero> {
        return try {
            if (publicKey.isEmpty() || privateKey.isEmpty()) {
                return emptyList()
            }
            val response = marvelApi.marvelService.getHeroes(
                timestamp = timestamp,
                hash = hash,
                apiKey = publicKey
            )
            response.data.results
        } catch (e: Exception) {
            println("Error fetching heroes: ${e.message}")
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun getHeroDetails(comicId: Int): Hero {
        val response = marvelApi.marvelService.getHeroDetails(
            comicId,
            timestamp = timestamp,
            hash = hash,
            publicKey = publicKey
        )
        return response.data.results.firstOrNull() ?: throw Exception("Comic book not found")
    }
}
