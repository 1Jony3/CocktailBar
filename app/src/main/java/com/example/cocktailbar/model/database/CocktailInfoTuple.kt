package com.example.cocktailbar.model.database

import androidx.room.ColumnInfo

data class CocktailInfoTuple(
    val id: Long,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB, name = "cocktail_image") val cocktailImage: ByteArray?,
    @ColumnInfo(name = "cocktail_name") val cocktailName: String,
    @ColumnInfo(name = "cocktail_description") val cocktailDescription: String?,
    @ColumnInfo(name = "cocktail_recipe") val cocktailRecipe: String?
    )
