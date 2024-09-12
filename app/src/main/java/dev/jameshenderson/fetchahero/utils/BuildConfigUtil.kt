package dev.jameshenderson.fetchahero.utils

import dev.jameshenderson.fetchahero.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BuildConfigUtil
    @Inject
    constructor() {
        @Suppress("KotlinConstantConditions")
        fun getPrivateApiKey(): String? =
            if (BuildConfig.PRIVATE_MARVEL_API_KEY != "empty_key") {
                BuildConfig.PRIVATE_MARVEL_API_KEY
            } else {
                null
            }

        @Suppress("KotlinConstantConditions")
        fun getPublicApiKey(): String? =
            if (BuildConfig.PRIVATE_MARVEL_API_KEY != "empty_key") {
                BuildConfig.PUBLIC_MARVEL_API_KEY
            } else {
                null
            }
    }
