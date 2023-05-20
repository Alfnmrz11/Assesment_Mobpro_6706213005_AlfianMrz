package org.d3if3005.deliveryfood.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3005.deliveryfood.db.RecipeDao
import org.d3if3005.deliveryfood.views.HistoryViewModel

class HistoryViewModelFactory (
    private val db: RecipeDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
            return HistoryViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}