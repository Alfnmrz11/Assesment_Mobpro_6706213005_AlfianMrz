package org.d3if3005.deliveryfood.views

import androidx.lifecycle.ViewModel
import org.d3if3005.deliveryfood.db.RecipeDao

class HistoryViewModel(db: RecipeDao) : ViewModel() {
    val data = db.getLastRecipe()
}
