package com.example.cocktailbar.screens.viewModels

import android.util.Log
import android.widget.Toast
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
class ListCocktailViewModel @Inject constructor(
    private val repository: CocktailDao
) : ViewModel() {

    private val _allCocktail = MutableLiveData<List<CocktailInfoTuple>>()
    val allCocktail: LiveData<List<CocktailInfoTuple>> = _allCocktail

    private val exceptionHandler =
        CoroutineExceptionHandler { _, throwable -> errorMessage.postValue(throwable.message) }
    private var job: Job? = null
    private val errorMessage = MutableLiveData<String>()

    init {
        getAllStatistic()
    }

    private fun getAllStatistic() {
        Log.d("lol", allCocktail.toString())
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            _allCocktail.value = repository.getAllCocktailData()
        }
    }

}