package com.madhavth.gardeningjournalapp.core.domain.entities

data class PlantData(
    var name: String,
    var type: String,
    var wateringFrequency: Int,
    var plantingDate: String
) {
    constructor() : this("", "", 0, "")
}

fun PlantData.toEntity(): Plant {
    return Plant(
        name = name,
        type = type,
        wateringFrequency = wateringFrequency,
        plantingDate = plantingDate
    )
}

fun Plant.toData(): PlantData {
    return PlantData(
        name = name,
        type = type,
        wateringFrequency = wateringFrequency,
        plantingDate = plantingDate
    )
}