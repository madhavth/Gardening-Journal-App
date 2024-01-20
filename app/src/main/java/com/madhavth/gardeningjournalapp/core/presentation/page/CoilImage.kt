package com.madhavth.gardeningjournalapp.core.presentation.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoilImage(imgUrl: String, title: String, modifier: Modifier = Modifier) {
    var imageUrl by remember { mutableStateOf(imgUrl) }

    Column(
    ) {
        Image( // The Image component to load the image with the Coil library
            painter = rememberImagePainter(data = imageUrl),
            contentDescription = null,
            modifier = modifier
        )
        Text(title)
    }
}