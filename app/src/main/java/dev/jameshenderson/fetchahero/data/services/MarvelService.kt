package dev.jameshenderson.fetchahero.data.services

import dev.jameshenderson.fetchahero.data.models.ComicsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {
    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("ts") timestamp: String,
        @Query("hash") hash: String,
        @Query("apikey") apiKey: String,
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): ComicsResponse

    @GET("v1/public/comics/{comicId}")
    suspend fun getComicDetails(
        @Path("comicId") comicId: Int,
        @Query("ts") timestamp: String,
        @Query("hash") hash: String,
        @Query("apikey") publicKey: String
    ): ComicsResponse
}
