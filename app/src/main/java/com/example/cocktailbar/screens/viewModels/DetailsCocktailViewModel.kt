package com.example.cocktailbar.screens.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktailbar.model.database.CocktailDao
import com.example.cocktailbar.model.database.CocktailInfoTuple
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsCocktailViewModel@Inject constructor(
    private val repository: CocktailDao
): ViewModel() {

    private val _cocktail = MutableLiveData<CocktailInfoTuple>()
    val cocktail: LiveData<CocktailInfoTuple> = _cocktail

    private val exceptionHandler =
        CoroutineExceptionHandler { _, throwable -> errorMessage.postValue(throwable.message) }
    private var job: Job? = null
    private val errorMessage = MutableLiveData<String>()

    fun getCoctail(cocktailID: Long) {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            _cocktail.value = repository.getCocktailDataByID(cocktailID)
        }
    }

}