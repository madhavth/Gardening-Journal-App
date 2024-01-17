package com.madhavth.gardeningjournalapp.core.data.di.modules

import android.content.Context
import androidx.room.Room
import com.madhavth.gardeningjournalapp.core.data.dao.PlantDao
import com.madhavth.gardeningjournalapp.core.data.database.PlantDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providePlantDatabase(@ApplicationContext context: Context): PlantDatabase {
        return synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                PlantDatabase::class.java,
                "plant_database"
            ).build()
            instance
        }
    }

    @Provides
    fun providePlantDao(plantDB: PlantDatabase): PlantDao {
        return plantDB.plantDao()
    }

}