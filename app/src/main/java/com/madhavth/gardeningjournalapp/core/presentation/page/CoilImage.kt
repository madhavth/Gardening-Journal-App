package com.madhavth.gardeningjournalapp.core.presentation.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.madhavth.gardeningjournalapp.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoilImage(imgUrl: String, title: String, modifier: Modifier = Modifier) {
    var imageUrl by remember { mutableStateOf(imgUrl) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image( // The Image component to load the image with the Coil library
            painter = rememberImagePainter(data = imageUrl, builder = {
                placeholder(R.mipmap.ic_launcher)
                crossfade(true)
            }),
            contentDescription = null,
            modifier = modifier
        )
        Text(
            title,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold

            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp).background(
                Color(0xffe0e0e0),
            )
        )
    }
}