package org.d3if3005.deliveryfood.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="newRecipe")
data class RecipeEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var title: String,
    var instruction: String,
    var ingredients: String
)
