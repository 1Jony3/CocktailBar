package com.example.cocktailbar.model.di

import android.content.Context
import androidx.room.Room
import com.example.cocktailbar.model.database.AppDatabase
import com.example.cocktailbar.model.database.CocktailDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
            .build()
    }

    @Provides
    fun provideСocktailDao(appDatabase: AppDatabase): CocktailDao {
        return appDatabase.getСocktailDao()
    }
}