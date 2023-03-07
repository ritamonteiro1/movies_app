package com.example.designsystem.widgets

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.R
import com.example.designsystem.theme.apptheme.MoviesAppTheme
import com.example.designsystem.theme.apptheme.MoviesTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LabeledCard(
    modifier: Modifier = Modifier,
    cardItems: CardItem,
    contentDescriptionImage: String = "",
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MoviesTheme.colors.moviesColors.surface,
            ),
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.surface,
        border = BorderStroke(
            MoviesTheme.sizes.border.x200,
            MoviesTheme.colors.moviesColors.primary
        ),
        elevation = 10.dp,
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                modifier = Modifier
                    .width(100.dp)
                    .height(200.dp),
                model = cardItems.image,
                contentDescription = contentDescriptionImage,
                contentScale = ContentScale.Fit,
                error = painterResource(id = R.drawable.ic_error),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                cardItems.texts.forEach {
                    RegularRow(title = it.title, subtitle = it.subtitle)
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Preview(widthDp = 280, heightDp = 640)
@Composable
private fun LabeledCardPreview() {
    MoviesAppTheme {
        LabeledCard(
            cardItems = CardItem(
                image = "",
                texts = listOf(
                    CardText(
                        title = "Title",
                        subtitle = "Subtitle"
                    ),
                    CardText(
                        title = "Title",
                        subtitle = "Subtitle"
                    ),
                    CardText(
                        title = "Title",
                        subtitle = "Subtitle"
                    ),
                    CardText(
                        title = "Title",
                        subtitle = "Subtitle"
                    ),
                )
            ),
            onClick = {},
        )
    }
}

data class CardItem(
    val image: String,
    val texts: List<CardText>,
)

data class CardText(
    val title: String,
    val subtitle: String,
)