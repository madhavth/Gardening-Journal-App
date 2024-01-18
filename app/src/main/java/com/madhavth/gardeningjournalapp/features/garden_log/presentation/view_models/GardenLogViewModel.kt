package com.madhavth.gardeningjournalapp.features.garden_log.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.madhavth.gardeningjournalapp.core.data.repositories.PlantRepository
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GardenLogViewModel @Inject constructor(
    private val plantRepository: PlantRepository
) : ViewModel() {
    suspend fun addPlant(plant: Plant) {
        plantRepository.insert(plant)
    }

    suspend fun updatePlant(plant: Plant) {
        plantRepository.update(plant)
    }

    suspend fun getPlantById(plantId: Int): LiveData<Plant> {
        return plantRepository.getPlantById(plantId)
    }

    suspend fun getAllPlants(): LiveData<List<Plant>> {
        return plantRepository.allPlants
    }
}