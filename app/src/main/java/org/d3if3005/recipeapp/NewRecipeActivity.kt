package org.d3if3005.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.d3if3005.deliveryfood.R
import org.d3if3005.deliveryfood.databinding.ActivityMainBinding
import org.d3if3005.recipeapp.utils.presenter.HomePresenter
import org.d3if3005.recipeapp.views.HomeView

class NewRecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_new_recipe)
    }


}