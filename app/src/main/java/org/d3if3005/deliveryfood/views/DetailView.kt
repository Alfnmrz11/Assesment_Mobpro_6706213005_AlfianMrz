package org.d3if3005.deliveryfood.views

import org.d3if3005.deliveryfood.data.local.Meal

interface DetailView {
    fun setMeal(meals: Meal)
    fun onErrorLoading(message: String?)
}