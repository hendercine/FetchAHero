package dev.jameshenderson.fetchahero.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.jameshenderson.fetchahero.data.api.MarvelApi
import dev.jameshenderson.fetchahero.data.services.MarvelService
import dev.jameshenderson.fetchahero.domain.repositories.HeroRepository
import dev.jameshenderson.fetchahero.domain.repositories.HeroRepositoryInterface
import dev.jameshenderson.fetchahero.utils.BuildConfigUtil

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideHeroRepository(marvelApi: MarvelApi, buildConfigUtil: BuildConfigUtil): HeroRepositoryInterface {
        return HeroRepository(marvelApi, buildConfigUtil)
    }

}