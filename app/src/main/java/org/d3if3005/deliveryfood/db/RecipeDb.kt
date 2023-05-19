package org.d3if3005.deliveryfood.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RecipeEntity::class], version = 1, exportSchema = false)
abstract class RecipeDb : RoomDatabase() {
    abstract val dao: RecipeDao
    companion object {
        @Volatile
        private var INSTANCE: RecipeDb? = null
        fun getInstance(context: Context): RecipeDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RecipeDb::class.java,
                        "newRecipe.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
