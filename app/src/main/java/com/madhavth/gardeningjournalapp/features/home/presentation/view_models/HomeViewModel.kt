package com.madhavth.gardeningjournalapp.features.home.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.madhavth.gardeningjournalapp.core.data.repositories.PlantRepository
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val plantRepository: PlantRepository
) : ViewModel() {
    suspend fun getAllPlants(): LiveData<List<Plant>> {
        return plantRepository.allPlants
    }
}