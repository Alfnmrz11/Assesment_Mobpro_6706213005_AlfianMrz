package org.d3if3005.recipeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.d3if3005.deliveryfood.R
import org.d3if3005.recipeapp.data.model.UserData
import org.d3if3005.deliveryfood.databinding.ActivityMainBinding
import org.d3if3005.deliveryfood.views.UserAdapter
import org.d3if3005.recipeapp.data.local.Category
import org.d3if3005.recipeapp.data.local.Meal
import org.d3if3005.recipeapp.utils.adapter.CategoryAdapter
import org.d3if3005.recipeapp.utils.adapter.MealAdapter
import org.d3if3005.recipeapp.utils.api.ApiUtils
import org.d3if3005.recipeapp.utils.presenter.HomePresenter
import org.d3if3005.recipeapp.views.HomeView

class MainActivity : AppCompatActivity(), HomeView {
    private lateinit var presenter: HomePresenter
    private lateinit var binding: ActivityMainBinding
    private lateinit var addsBtn:FloatingActionButton
    private lateinit var recv:RecyclerView
    private lateinit var userList:ArrayList<UserData>
    private lateinit var userAdapter:UserAdapter

    companion object {
        const val EXTRA_CATEGORY = "category"
        const val EXTRA_POSITION = "position"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**Set List*/
        userList = ArrayList()

        /**Set Find Id*/
        addsBtn = findViewById(R.id.floatingactionbutton)
        recv = findViewById(R.id.rv_header)

        /**Set Adapter*/
        userAdapter = UserAdapter(this, userList)

        /**Set Recycler View*/
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter

        /**Set Dialog*/
        addsBtn.setOnClickListener { addInfo() }

        /**Set Floating Button*/
//        var i:Int = 0
//        binding.floatingactionbutton.setOnClickListener{
//            i++
//            //header.text = i.toString();
//            Log.d("Tombol Di Klik", "Tombol Berhasil")
//        }


        presenter = HomePresenter(this)

        with(presenter) {
            getMeals()
            getCategories()
        }
    }

    private fun addInfo(){
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.activity_add_item_new_recipe, null)

        /**Set View*/
        val titleNewRecipe = v.findViewById<EditText>(R.id.titleNewRecipe)
        val instructionNewRecipe = v.findViewById<EditText>(R.id.instructionNewRecipe)
        val ingredientNewRecipe = v.findViewById<EditText>(R.id.ingredientNewRecipe)


        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
            dialog, ->
            val title = titleNewRecipe.text.toString()
            val instruction = instructionNewRecipe.text.toString()
            val ingredient = ingredientNewRecipe.text.toString()
            userList.add(UserData("Title : $titleNewRecipe", "Instruction : $instructionNewRecipe", "Ingredient : $ingredientNewRecipe"))
            userAdapter.notifyDataSetChanged()
            Toast.makeText(this, "Success Add New Recipe", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog, ->
            dialog.dismiss()
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()
    }

    override fun setMeals(meals: ArrayList<Meal>) {
        val mealAdapter = MealAdapter(meals)

        binding.rvHeader.apply {
            adapter = mealAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    override fun setCategories(categories: ArrayList<Category>) {
        val categoryAdapter = CategoryAdapter(categories)

        binding.rvCategory.apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(
                this@MainActivity,
                2,
                GridLayoutManager.VERTICAL,
                false
            )
            isNestedScrollingEnabled = true
        }
    }

    override fun onErrorLoading(message: String?) {
        ApiUtils().showDialog(this, "Failed to fetch data!", message!!)
    }
}