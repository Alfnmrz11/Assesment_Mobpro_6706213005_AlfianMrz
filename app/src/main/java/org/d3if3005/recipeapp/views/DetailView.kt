package org.d3if3005.recipeapp.views

import org.d3if3005.recipeapp.data.local.Meal

interface DetailView {
    fun setMeal(meals: Meal)
    fun onErrorLoading(message: String?)
}