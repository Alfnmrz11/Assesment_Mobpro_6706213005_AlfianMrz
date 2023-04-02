package org.d3if3005.deliveryfood.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.d3if3005.deliveryfood.data.local.Meal

data class Meals(
    @SerializedName("meals")
    @Expose
    val meals: ArrayList<Meal>
)