package org.d3if3005.deliveryfood.data.local

import java.io.Serializable

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
): Serializable