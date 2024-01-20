package com.madhavth.gardeningjournalapp.features.plant_details.presentation.page

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import com.madhavth.gardeningjournalapp.core.presentation.page.CoilImage

@Composable
fun PlantDetailsScreen(plant: Plant?) {
    val scrollState = rememberScrollState()

    if (plant == null) {
        Text("Something went wrong... cant find plant")
        return
    }
    Box() {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.scrollable(scrollState, orientation = Orientation.Vertical)
        ) {
            CoilImage(
                imgUrl = "https://source.unsplash.com/random/400x400/?${plant.name}",
                title = plant.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            )

            Column(modifier = Modifier.padding(12.dp)) {
                PlantInfo(key = "Type", value = plant.type)
                PlantInfo(key = "Watering Frequency", value = plant.wateringFrequency.toString())
                PlantInfo(key = "Planting Date", value = plant.plantingDate)
            }
        }
    }
}

@Composable
fun PlantInfo(key: String, value: String) {
    Row {
        Text(
            "$key:", fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 8.dp)
        )
        Text(value, modifier = Modifier.weight(1f))
    }
}


@Preview(showSystemUi = true)
@Composable
fun PlantDetailsScreenPreview() {
    PlantDetailsScreen(
        Plant(
            1,
            "name",
            "type",
            2, "notes"
        )
    )
}