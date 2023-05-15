package org.d3if3005.recipeapp.views

import org.d3if3005.recipeapp.data.local.Meal

interface CategoryView {
    fun setMeal(meals: ArrayList<Meal>)
    fun onErrorLoading(message: String?)
}