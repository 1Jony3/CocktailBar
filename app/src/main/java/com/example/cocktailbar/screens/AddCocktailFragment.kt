package com.example.cocktailbar.screens

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import com.example.cocktailbar.R
import com.example.cocktailbar.databinding.FragmentAddCocktailBinding
import com.example.cocktailbar.screens.viewModels.AddCocktailViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.ByteArrayOutputStream

@AndroidEntryPoint
class AddCocktailFragment : Fragment(R.layout.fragment_add_cocktail) {

    private lateinit var binding: FragmentAddCocktailBinding

    private val viewModel: AddCocktailViewModel by viewModels()

   /* val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
            //load image
            }
        }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddCocktailBinding.inflate(inflater, container, false)

        /*binding.loadImagesIm.setOnClickListener{
            val permissionStatus = ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_MEDIA_IMAGES
            )

            Log.d("lol", "image click")
            if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
                Log.d("lol", "tik permission not")
                requestPermissionLauncher.launch(
                    Manifest.permission.READ_MEDIA_IMAGES)
            }
        }*/

        binding.saveBt.setOnClickListener{
            viewModel.insertNewCocktail(
                cocktailName = binding.cocktailNameTiet.toString(),
                cocktailDescription = binding.cocktailDescriptionTiet.toString(),
                cocktailRecipe = binding.cocktailRecipeTiet.toString()
            )
        }
        return binding.root
    }

    private fun imageToBitmap(image: ImageView): ByteArray? {
        val bitmap = (image.drawable as BitmapDrawable).bitmap
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)

        return stream.toByteArray()
    }
}