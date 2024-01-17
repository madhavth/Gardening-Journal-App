package com.madhavth.gardeningjournalapp.core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant

@Dao
interface PlantDao {
    @Query("SELECT * FROM plants")
    fun getAllPlants(): LiveData<List<Plant>>

    @Insert
    suspend fun insert(plant: Plant)

    @Query("DELETE FROM plants")
    suspend fun deleteAll(): Int

    @Update
    suspend fun update(plant: Plant): Int

    @Query("DELETE FROM plants WHERE id = :plantId")
    suspend fun delete(plantId: Int): Int

    @Query("SELECT * FROM plants WHERE id = :plantId")
    fun getPlantById(plantId: Int): LiveData<Plant>
}