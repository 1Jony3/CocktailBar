package com.example.cocktailbar.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.example.cocktailbar.R
import com.example.cocktailbar.databinding.FragmentListCocktailBinding
import com.example.cocktailbar.model.adapter.CocktailAdapter
import androidx.navigation.fragment.findNavController
import com.example.cocktailbar.model.adapter.OnItemClickListener
import com.example.cocktailbar.screens.viewModels.ListCocktailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListCocktailFragment : Fragment(R.layout.fragment_list_cocktail) {

    private lateinit var binding: FragmentListCocktailBinding
    private lateinit var adapter: CocktailAdapter

    private val viewModel: ListCocktailViewModel by viewModels()

    private val onClickListener = object : OnItemClickListener {
        override fun onItemClick(cocktailID: Long) {
            openDetails(cocktailID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListCocktailBinding.inflate(inflater, container, false)
        adapter = CocktailAdapter()
        adapter.SetOnItemClickListener(onClickListener)

        viewModel.allCocktail.observe(viewLifecycleOwner) { allCocktail ->
            Log.d("lol", "list ${allCocktail}")
            if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED) {
                binding.greetingLl.visibility = View.GONE
                adapter.cocktail = allCocktail
                binding.listCocktailRv.adapter = adapter
            }
        }
        binding.addBt.setOnClickListener { openAddCocktail() }
        return binding.root
    }

    private fun openAddCocktail(){
        findNavController().navigate(
            R.id.action_listCocktailFragment_to_addCocktailFragment,
        )
    }

    private fun openDetails(cocktailID: Long){
        findNavController().navigate(
            R.id.action_listCocktailFragment_to_detailsCocktailFragment,
            bundleOf(ARG_COCKTAIL_ID to cocktailID)
        )
    }

    companion object{
        const val ARG_COCKTAIL_ID = "cocktailID"
    }
}

