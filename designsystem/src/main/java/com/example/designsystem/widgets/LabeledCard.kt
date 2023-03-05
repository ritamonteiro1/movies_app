package com.example.featurepopularmovies.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LabeledCard(){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.surface,
        border = BorderStroke(2.dp, MaterialTheme.colors.primary)

    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun LabeledCardPreview() {
//    MoviesAppTheme {
//        LabeledCard()
//    }
}