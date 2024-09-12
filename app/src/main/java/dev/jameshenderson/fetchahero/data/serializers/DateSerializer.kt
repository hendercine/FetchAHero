package dev.jameshenderson.fetchahero.data.serializers

import androidx.core.net.ParseException
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.text.SimpleDateFormat
import java.util.Date

object DateDeserializer : JsonDeserializer<Date?> {
    private val df =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", java.util.Locale.US)

    override fun deserialize(
        json: JsonElement?,
        typeOfT: java.lang.reflect.Type?,
        context: JsonDeserializationContext?,
    ): Date? =
        try {
            json?.asString?.let { df.parse(it) }
        } catch (e: ParseException) {
            println("Error parsing date: ${e.message}")
            Date()
        }
}
