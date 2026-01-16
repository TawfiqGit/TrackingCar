package com.tawfiqdev.di

import android.content.Context
import androidx.room.Room
import com.tawfiqdev.database.TrackingCarDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/***
 * Sert à expliquer à Hilt comment construire Database + DAOs.*
 * **/
@Module // Utilisée pour regrouper et fournir des dépendances
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides //Créez l'objet vous-même
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) : TrackingCarDatabase {
        return Room
            .databaseBuilder(
                appContext,
                TrackingCarDatabase::class.java,
                "trackingCarDatabase"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideUserDao(db: TrackingCarDatabase) = db.userDao()
}