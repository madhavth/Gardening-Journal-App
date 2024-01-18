package com.madhavth.gardeningjournalapp.features.plant_details.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.madhavth.gardeningjournalapp.core.data.repositories.PlantRepository
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlantDetailViewModel @Inject constructor(
    private val plantRepository: PlantRepository,
    @Assisted private val plantId: Int,
) : ViewModel() {
     fun getPlantById(): LiveData<Plant> {
        return plantRepository.getPlantById(plantId)
    }
    suspend fun updatePlant(plant: Plant) {
        plantRepository.update(plant)
    }

    suspend fun removePlant(plant: Plant) {
        plantRepository.delete(plant)
    }

}