package com.madhavth.gardeningjournalapp.core.domain.entities

import java.util.Date

data class PlantEntity(
    val name: String,
    val type: String,
    val wateringFrequency: Int,
    val plantingDate: Date
)
