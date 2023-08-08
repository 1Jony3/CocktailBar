package com.example.cocktailbar.model

import com.example.cocktailbar.model.database.CocktailDao
import com.example.cocktailbar.model.database.entities.CocktailDbEntity
import com.example.cocktailbar.model.database.CocktailInfoTuple
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailRepository @Inject constructor(
    override var сocktailDao: CocktailDao
): Repository {

    override suspend fun insertNewCocktailData(cocktailDbEntity: CocktailDbEntity) {
        withContext(Dispatchers.IO) {
            сocktailDao.insertNewCocktailData(cocktailDbEntity)
        }
    }

    override suspend fun getAllCocktailData(): List<CocktailInfoTuple> {
        return withContext(Dispatchers.IO) {
            return@withContext сocktailDao.getAllCocktailData()
        }
    }

    override suspend fun removeCocktailDataById(id: Long) {
        withContext(Dispatchers.IO) {
            сocktailDao.deleteCocktailDataByID(id)
        }
    }

    override suspend fun selectCocktailDataByID(cocktailID: Long): CocktailInfoTuple {
        return withContext(Dispatchers.IO){
            return@withContext сocktailDao.getCocktailDataByID(cocktailID)
        }
    }
}