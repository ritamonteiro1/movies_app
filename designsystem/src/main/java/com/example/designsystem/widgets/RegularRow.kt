package com.example.designsystem.widgets

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.apptheme.MoviesAppTheme
import com.example.designsystem.theme.apptheme.MoviesTheme


@Composable
fun RegularRow(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = title, style = MoviesTheme.typography.h1)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = subtitle, style = MoviesTheme.typography.h6)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Preview(widthDp = 280, heightDp = 640)
@Composable
private fun RegularRowPreview() {
    MoviesAppTheme {
        RegularRow(
            title = "Title",
            subtitle = "Subtitle",
        )
    }
}