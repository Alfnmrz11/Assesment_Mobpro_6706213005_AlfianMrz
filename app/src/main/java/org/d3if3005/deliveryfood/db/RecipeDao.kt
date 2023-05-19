package org.d3if3005.deliveryfood.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeDao {
    @Insert
    fun insert(bmi: RecipeEntity)
    @Query("SELECT * FROM newRecipe ORDER BY id DESC LIMIT 1")
    fun getLastBmi(): LiveData<RecipeEntity?>
}