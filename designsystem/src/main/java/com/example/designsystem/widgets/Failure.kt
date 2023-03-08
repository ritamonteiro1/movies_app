package com.example.designsystem.widgets

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.apptheme.MoviesAppTheme
import com.example.designsystem.theme.apptheme.MoviesTheme

@Composable
fun Failure(
    modifier: Modifier = Modifier,
    message: String,
    textButton: String,
    onRetry: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = message, style = MoviesTheme.typography.h5)
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = MoviesTheme.colors.moviesColors.error),
            onClick = { onRetry.invoke() }) {
            Text(text = textButton, style = MoviesTheme.typography.h4)
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Preview(widthDp = 280, heightDp = 640)
@Composable
private fun FailurePreview() {
    MoviesAppTheme {
        Failure(message = "Ocorreu um erro", textButton = "Tentar novamente", onRetry = {})
    }
}