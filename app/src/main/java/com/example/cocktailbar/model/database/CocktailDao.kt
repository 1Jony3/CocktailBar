package com.example.cocktailbar.model.database

import androidx.room.*
import com.example.cocktailbar.model.database.entities.CocktailDbEntity
import javax.inject.Singleton

@Singleton
@Dao
interface CocktailDao {

    @Insert(entity = CocktailDbEntity::class)
    fun insertNewCocktailData(cocktail: CocktailDbEntity)

    @Query("SELECT cocktail.id, cocktail_image, cocktail_name, cocktail_description, cocktail_recipe FROM cocktail")
    fun getAllCocktailData(): List<CocktailInfoTuple>

    @Query("DELETE FROM cocktail WHERE id = :cocktailID")
    fun deleteCocktailDataByID(cocktailID: Long)

    @Query("SELECT cocktail.id, cocktail_image, cocktail_name, cocktail_description, cocktail_recipe FROM cocktail WHERE id = :cocktailID")
    fun getCocktailDataByID(cocktailID: Long): CocktailInfoTuple
}