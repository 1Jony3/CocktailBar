package com.example.cocktailbar.screens.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktailbar.model.database.CocktailDao
import com.example.cocktailbar.model.database.entities.Cocktail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddCocktailViewModel @Inject constructor(
    private val repository: CocktailDao
) : ViewModel() {

    private val exceptionHandler =
        CoroutineExceptionHandler { _, throwable -> errorMessage.postValue(throwable.message) }
    private var job: Job? = null
    private val errorMessage = MutableLiveData<String>()

        fun insertNewCocktail(
            cocktailImage: ByteArray? = null,
            cocktailName: String,
            cocktailDescription: String? = null,
            cocktailRecipe: String? = null
        ){
            val newCocktail = Cocktail(cocktailImage, cocktailName, cocktailDescription, cocktailRecipe)
            job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
                repository.insertNewCocktailData(newCocktail.toCocktailDbEntity())
            }
        }

}