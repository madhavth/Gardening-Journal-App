package com.madhavth.gardeningjournalapp.features.plant_details.presentation.view_models

import android.service.quicksettings.Tile
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madhavth.gardeningjournalapp.core.data.repositories.PlantRepository
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.EntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlantDetailViewModel @Inject constructor(
    private val plantRepository: PlantRepository
) : ViewModel() {
     fun getPlantById(plantId: Int): LiveData<Plant> {
        return plantRepository.getPlantById(plantId)
    }
    suspend fun updatePlant(plant: Plant) {
        plantRepository.update(plant)
    }
    suspend fun removePlant(plant: Plant) {
        plantRepository.delete(plant)
    }
}