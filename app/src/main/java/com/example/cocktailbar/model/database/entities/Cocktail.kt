package com.example.cocktailbar.model.database.entities


data class Cocktail(
    val image: ByteArray?,
    val cocktailName: String,
    val cocktailDescription: String?,
    val cocktailRecipe: String?
) {
    fun toCocktailDbEntity(): CocktailDbEntity = CocktailDbEntity(
        id = 0,
        cocktailImage = image,
        cocktailName = cocktailName,
        cocktailDescription = cocktailDescription,
        cocktailRecipe = cocktailRecipe
    )
}