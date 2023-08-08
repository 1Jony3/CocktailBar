package com.example.cocktailbar.model.database

import androidx.room.*
import com.example.cocktailbar.model.database.entities.CocktailDbEntity

@Database(
    version = 1,
    entities = [
        CocktailDbEntity::class
    ]
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getСocktailDao(): CocktailDao
}