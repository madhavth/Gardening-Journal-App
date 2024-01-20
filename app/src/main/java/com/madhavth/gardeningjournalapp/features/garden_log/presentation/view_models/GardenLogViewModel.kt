package com.madhavth.gardeningjournalapp.features.garden_log.presentation.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.madhavth.gardeningjournalapp.core.data.database.PlantDatabase
import com.madhavth.gardeningjournalapp.core.data.repositories.PlantRepository
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import com.madhavth.gardeningjournalapp.core.domain.entities.PlantData
import com.madhavth.gardeningjournalapp.core.domain.entities.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GardenLogViewModel constructor(
    application: Application
) : AndroidViewModel(application) {
    private val plantRepository: PlantRepository = PlantRepository(PlantDatabase
        .getDatabase(application.applicationContext)
        .plantDao()
    )

    private var plantData: PlantData = PlantData()

    private suspend fun addPlant(plant: Plant) {
        withContext(Dispatchers.IO) {
            plantRepository.insert(plant)
        }
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

    fun onNameChanged(name: String) {
        plantData.name = name
    }

    fun onTypeChanged(type: String) {
        plantData.type = type
    }

    fun onWateringFrequencyChanged(wateringFrequency: Int) {
        plantData.wateringFrequency = wateringFrequency
    }

    fun onPlantingDateChanged(plantingDate: String) {
        plantData.plantingDate = plantingDate
    }

    suspend fun savePlant() {
        addPlant(plantData.toEntity())
    }

    fun validatePlantData(): Boolean {
        if(plantData.name.isEmpty()) {
            return false
        }
        if(plantData.type.isEmpty()) {
            return false
        }

        if(plantData.plantingDate.isEmpty()) {
            return false
        }

        if(plantData.wateringFrequency == 0) {
            return false
        }

        return true
    }

}