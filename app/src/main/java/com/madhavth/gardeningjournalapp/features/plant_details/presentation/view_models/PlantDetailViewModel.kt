package com.madhavth.gardeningjournalapp.features.plant_details.presentation.view_models

import android.service.quicksettings.Tile
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
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

    private var _plant: MutableLiveData<Plant?> = MutableLiveData<Plant?>(null)
    val plant: LiveData<Plant?> = _plant

    fun getPlantById(plantId: Int): LiveData<Plant> {
        return plantRepository.getPlantById(plantId)
    }
    suspend fun updatePlant(plant: Plant) {
        plantRepository.update(plant)
    }
    fun setPlant(plant: Plant) {
        _plant.value = plant
    }

}