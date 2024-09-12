package dev.jameshenderson.fetchahero.data.models

import java.util.Date

data class Hero(
    val id: Int? = null,
    val digitalId: Int? = null,
    val title: String? = null,
    val issueNumber: Double? = null,
    val variantDescription: String? = null,
    val description: String? = null,
    val modified: HeroDate? = null,
    val isbn: String? = null,
    val upc: String? = null,
    val diamondCode: String? = null,
    val ean: String? = null,
    val issn: String? = null,
    val format: String? = null,
    val pageCount: Int? = null,
    val textObjects: List<TextObject>? = null,
    val resourceURI: String? = null,
    val urls: List<Url>? = null,
    val series: SeriesSummary? = null,
    val variants: List<HeroSummary>? = null,
    val collections: List<HeroSummary>? = null,
    val collectedIssues: List<HeroSummary>? = null,
    val dates: List<HeroDate>? = null,
    val prices: List<HeroPrice>? = null,
    val thumbnail: HeroImage? = null,
    val images: List<HeroImage>? = null,
    val creators: CreatorList? = null,
    val characters: CharacterList? = null,
    val stories: StoryList? = null,
    val events: EventList? = null,
)

data class TextObject(
    val type: String? = null,
    val language: String? = null,
    val text: String? = null,
)

data class Url(
    val type: String? = null,
    val url: String? = null,
)

data class SeriesSummary(
    val resourceURI: String? = null,
    val name: String? = null,
)

data class HeroSummary(
    val resourceURI: String? = null,
    val name: String? = null,
)

data class HeroDate(
    val type: String? = null,
    val date: Date? = null,
)

data class HeroPrice(
    val type: String? = null,
    val price: Float? = null,
)

data class HeroImage(
    val path: String? = null,
    val extension: String? = null,
)

data class CreatorList(
    val available: Int? = null,
    val returned: Int? = null,
    val collectionURI: String? = null,
    val items: List<CreatorSummary>? = null,
)

data class CreatorSummary(
    val resourceURI: String? = null,
    val name: String? = null,
    val role: String? = null,
)

data class CharacterList(
    val available: Int? = null,
    val returned: Int? = null,
    val collectionURI: String? = null,
    val items: List<CharacterSummary>? = null,
)

data class CharacterSummary(
    val resourceURI: String? = null,
    val name: String? = null,
    val role: String? = null,
)

data class StoryList(
    val available: Int? = null,
    val returned: Int? = null,
    val collectionURI: String? = null,
    val items: List<StorySummary>? = null,
)

data class StorySummary(
    val resourceURI: String? = null,
    val name: String? = null,
    val type: String? = null,
)

data class EventList(
    val available: Int? = null,
    val returned: Int? = null,
    val collectionURI: String? = null,
    val items: List<EventSummary>? = null,
)

data class EventSummary(
    val resourceURI: String? = null,
    val name: String? = null,
)
