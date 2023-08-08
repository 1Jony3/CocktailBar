package com.example.cocktailbar.model.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.cocktailbar.databinding.ItemCocktailBinding
import com.example.cocktailbar.model.database.CocktailInfoTuple


interface OnItemClickListener {
    fun onItemClick(cocktailID: Long)
}

class CocktailAdapter: RecyclerView.Adapter<CocktailAdapter.CocktailHolder>() {

    private lateinit var myItemClickListener: OnItemClickListener

    fun SetOnItemClickListener(mItemClickListener: OnItemClickListener) {
        myItemClickListener = mItemClickListener
    }

    var cocktail: List<CocktailInfoTuple> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    private lateinit var glideManager: RequestManager

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCocktailBinding.inflate(inflater, parent, false)

        glideManager = Glide.with(binding.root)

        return CocktailHolder(binding)
    }

    override fun onBindViewHolder(holder: CocktailHolder, position: Int) {
        val cocktail = cocktail[position]
        holder.itemView.setOnClickListener { myItemClickListener.onItemClick(cocktail.id) }
        with(holder.binding){
            cocktail.cocktailImage.let {
                glideManager
                    .load(it)
                    .into(cocktailImageIm)
            }
            cocktailNameTv.text = cocktail.cocktailName
        }
    }

    override fun getItemCount() = cocktail.size

    class CocktailHolder(val binding: ItemCocktailBinding): RecyclerView.ViewHolder(binding.root)
}