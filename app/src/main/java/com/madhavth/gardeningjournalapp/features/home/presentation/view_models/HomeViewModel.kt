package com.madhavth.gardeningjournalapp.features.home.presentation.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.madhavth.gardeningjournalapp.core.data.database.PlantDatabase
import com.madhavth.gardeningjournalapp.core.data.repositories.PlantRepository
import com.madhavth.gardeningjournalapp.core.domain.entities.PlantData
import com.madhavth.gardeningjournalapp.core.domain.entities.toEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {
    suspend fun addDummyData() {
        plantRepository.insert(
            PlantData(
                name = "Rose",
                type = "Flower",
                wateringFrequency = 2,
                plantingDate = "2021-01-01"
            ).toEntity()
        )
        plantRepository.insert(
            PlantData(
                name = "Tulip",
                type = "Flower",
                wateringFrequency = 3,
                plantingDate = "2021-01-01"
            ).toEntity()
        )
        plantRepository.insert(
            PlantData(
                name = "Lily",
                type = "Flower",
                wateringFrequency = 4,
                plantingDate = "2021-01-01"
            ).toEntity()
        )
        plantRepository.insert(
            PlantData(
                name = "Sunflower",
                type = "Flower",
                wateringFrequency = 5,
                plantingDate = "2021-01-01"
            ).toEntity()
        )
        plantRepository.insert(
            PlantData(
                name = "Cactus",
                type = "Flower",
                wateringFrequency = 6,
                plantingDate = "2021-01-01"
            ).toEntity()
        )
        plantRepository.insert(
            PlantData(
                name = "Lavender",
                type = "Flower",
                wateringFrequency = 7,
                plantingDate = "2021-01-01"
            ).toEntity()
        )
        plantRepository.insert(
            PlantData(
                name = "Daisy",
                type = "Flower",
                wateringFrequency = 8,
                plantingDate = "2021-01-01"
            ).toEntity()
        )
    }

    private val plantRepository: PlantRepository = PlantRepository(
        PlantDatabase
        .getDatabase(application.applicationContext)
        .plantDao()
    )


    val allPlants = plantRepository.allPlants
}