package com.example.cocktailbar.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.cocktailbar.R
import com.example.cocktailbar.databinding.FragmentListCocktailBinding
import com.example.cocktailbar.screens.ListCocktailFragment.Companion.ARG_COCKTAIL_ID
import com.example.cocktailbar.screens.viewModels.DetailsCocktailViewModel


class DetailsCocktailFragment : Fragment(R.layout.fragment_details_cocktail) {

    private lateinit var binding: FragmentListCocktailBinding
    private val viewModel: DetailsCocktailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListCocktailBinding.inflate(inflater, container, false)

        viewModel.getCoctail(requireArguments().getLong(ARG_COCKTAIL_ID)!!)

        return binding.root
    }

}