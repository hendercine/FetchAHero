package dev.jameshenderson.fetchahero.data.api

import com.google.gson.GsonBuilder
import dev.jameshenderson.fetchahero.data.serializers.DateDeserializer
import dev.jameshenderson.fetchahero.data.services.MarvelService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarvelApi
    @Inject
    constructor() {
        private val gson =
            GsonBuilder()
                .registerTypeAdapter(Date::class.java, DateDeserializer)
                .create()
        private val retrofit: Retrofit =
            Retrofit
                .Builder()
                .baseUrl("https://gateway.marvel.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        val marvelService: MarvelService = retrofit.create(MarvelService::class.java)
    }
