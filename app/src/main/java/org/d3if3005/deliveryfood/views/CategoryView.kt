package org.d3if3005.deliveryfood.views

import org.d3if3005.deliveryfood.data.local.Meal

interface CategoryView {
    fun setMeal(meals: ArrayList<Meal>)
    fun onErrorLoading(message: String?)
}