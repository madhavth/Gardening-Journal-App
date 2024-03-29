package com.madhavth.gardeningjournalapp.core.data.repositories

import androidx.lifecycle.LiveData
import com.madhavth.gardeningjournalapp.core.data.dao.PlantDao
import com.madhavth.gardeningjournalapp.core.data.database.PlantDatabase
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import javax.inject.Inject

class PlantRepository @Inject constructor(
    private val plantDao: PlantDao,
) {
    val allPlants: LiveData<List<Plant>> = plantDao.getAllPlants()
    suspend fun insert(plant: Plant) {
        plantDao.insert(plant)
    }
    suspend fun update(plant: Plant) {
        plantDao.update(plant)
    }
    suspend fun delete(plant: Plant) {
        plantDao.delete(plant.id)
    }
    fun getPlantById(plantId: Int): LiveData<Plant> {
        return plantDao.getPlantById(plantId)
    }
}