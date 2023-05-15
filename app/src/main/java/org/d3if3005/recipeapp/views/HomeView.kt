package org.d3if3005.recipeapp.views

import org.d3if3005.recipeapp.data.local.Category
import org.d3if3005.recipeapp.data.local.Meal

interface HomeView {
    fun setMeals(meals: ArrayList<Meal>)
    fun setCategories(categories: ArrayList<Category>)

    fun onErrorLoading(message: String?)
}
