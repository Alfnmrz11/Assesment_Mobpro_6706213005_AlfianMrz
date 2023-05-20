package org.d3if3005.deliveryfood.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3005.deliveryfood.MainViewModel
import org.d3if3005.deliveryfood.db.RecipeDao

class MainViewModelFactory (
        private val db: RecipeDao
        ) : ViewModelProvider.Factory {
            @Suppress("unchecked_cast")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                    return MainViewModel(db) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
}