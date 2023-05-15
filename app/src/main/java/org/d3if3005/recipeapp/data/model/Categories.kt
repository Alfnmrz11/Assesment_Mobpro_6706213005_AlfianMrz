package org.d3if3005.recipeapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.d3if3005.recipeapp.data.local.Category


data class Categories(
    @SerializedName("categories")
    @Expose
    val categories: ArrayList<Category>
)