package dev.jameshenderson.fetchahero.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.jameshenderson.fetchahero.R
import dev.jameshenderson.fetchahero.data.models.Hero

@Composable
fun HeroUIComponent(hero: Hero, onHeroClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onHeroClick)
            .padding(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            val imageUrl = "${hero.thumbnail?.path}.${hero.thumbnail?.extension}".replace("http", "https")
            println("_______________ imageUrl is: $imageUrl")
            Column(
                modifier = Modifier.weight(1f)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Hero Cover Thumbnail",
                    placeholder = painterResource(id = R.drawable.no_image_2x),
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
            }
            Column(
                modifier = Modifier.weight(3f)
            ) {
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.Start)
                ) {
                    Text(
                        text = hero.title ?: "Unknown Title",
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.Start)
                ) {
                    Text(
                        text = hero.description ?: "No Description found",
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
