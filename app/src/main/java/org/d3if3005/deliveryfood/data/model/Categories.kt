package org.d3if3005.deliveryfood.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.d3if3005.deliveryfood.data.local.Category


data class Categories(
    @SerializedName("categories")
    @Expose
    val categories: ArrayList<Category>
)