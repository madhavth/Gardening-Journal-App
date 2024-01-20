package com.madhavth.gardeningjournalapp.features.home.presentation.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.madhavth.gardeningjournalapp.core.data.database.PlantDatabase
import com.madhavth.gardeningjournalapp.core.data.repositories.PlantRepository
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {
    private val plantRepository: PlantRepository = PlantRepository(
        PlantDatabase
        .getDatabase(application.applicationContext)
        .plantDao()
    )


    val allPlants = plantRepository.allPlants
}