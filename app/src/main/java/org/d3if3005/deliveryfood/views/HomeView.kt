package org.d3if3005.deliveryfood.views

import org.d3if3005.deliveryfood.data.local.Category
import org.d3if3005.deliveryfood.data.local.Meal

interface HomeView {
    fun setMeals(meals: ArrayList<Meal>)
    fun setCategories(categories: ArrayList<Category>)

    fun onErrorLoading(message: String?)
}
