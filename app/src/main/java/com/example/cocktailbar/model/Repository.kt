package com.example.cocktailbar.model

import com.example.cocktailbar.model.database.CocktailDao
import com.example.cocktailbar.model.database.entities.CocktailDbEntity
import com.example.cocktailbar.model.database.CocktailInfoTuple


interface Repository {
    var сocktailDao: CocktailDao
    suspend fun insertNewCocktailData(cocktailDbEntity: CocktailDbEntity)
    suspend fun getAllCocktailData(): List<CocktailInfoTuple>
    suspend fun removeCocktailDataById(id: Long)
    suspend fun selectCocktailDataByID(cocktailID: Long): CocktailInfoTuple
}