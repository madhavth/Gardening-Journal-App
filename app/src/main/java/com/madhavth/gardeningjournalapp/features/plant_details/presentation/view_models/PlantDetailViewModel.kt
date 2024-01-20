package com.madhavth.gardeningjournalapp.features.plant_details.presentation.view_models

import android.app.Application
import android.service.quicksettings.Tile
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.madhavth.gardeningjournalapp.core.data.database.PlantDatabase
import com.madhavth.gardeningjournalapp.core.data.repositories.PlantRepository
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.EntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class PlantDetailViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val plantRepository: PlantRepository = PlantRepository(
        PlantDatabase
        .getDatabase(application.applicationContext)
        .plantDao()
    )

    private var _plant: MutableStateFlow<Plant?> = MutableStateFlow<Plant?>(null)
    val plant: StateFlow<Plant?> = _plant

    fun getPlantById(plantId: Int): LiveData<Plant> {
        return plantRepository.getPlantById(plantId)
    }
    suspend fun updatePlant(plant: Plant) {
        plantRepository.update(plant)
    }

    suspend fun deletePlant(plant: Plant) {
        plantRepository.delete(plant)
    }

    fun setPlant(plant: Plant) {
        _plant.value = plant
    }

}