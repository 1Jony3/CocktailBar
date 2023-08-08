package com.example.cocktailbar.model.di

import com.example.cocktailbar.model.CocktailRepository
import com.example.cocktailbar.model.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindCocktailRepository(
        cocktailRepository: CocktailRepository
    ): Repository
}