package org.d3if3005.deliveryfood

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3005.deliveryfood.data.model.UserData
import org.d3if3005.deliveryfood.db.RecipeDao
import org.d3if3005.deliveryfood.db.RecipeDb
import org.d3if3005.deliveryfood.db.RecipeEntity
import org.d3if3005.deliveryfood.ui.factory.MainViewModelFactory

class MainViewModel(private val db:RecipeDao) : ViewModel() {
    private val UserData = MutableLiveData<UserData?>()
    val data = db.getLastRecipe()

    private val viewModel: MainViewModel by lazy {
        val db = RecipeDb.getInstance(requireContext())
        val factory = MainViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }
    fun newRecipe(title: String, intruction: String, ingredient: String): MutableLiveData<UserData?> {
        return UserData

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataRecipe = RecipeEntity(
                    title = title,
                    instruction = intruction,
                    ingredients = ingredient
                )
                db.insert(dataRecipe)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState:Bundle?){
        viewModel.data.observe(viewLifecycleOwner, {
            if (it == null) return@observe
            Log.d("NewRecipe", "Data tersimpan. ID = ${it.id}")
        })
    }
}