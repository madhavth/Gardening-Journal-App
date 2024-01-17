package com.madhavth.gardeningjournalapp.core.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.madhavth.gardeningjournalapp.core.data.dao.PlantDao
import com.madhavth.gardeningjournalapp.core.domain.entities.Plant

@Database(entities=[Plant::class], version=1, exportSchema = false)
abstract class PlantDatabase: RoomDatabase() {

    abstract fun plantDao(): PlantDao

    companion object {
        @Volatile
        private var INSTANCE: PlantDatabase? = null

        fun getDatabase(context: Context): PlantDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlantDatabase::class.java,
                    "plant_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}