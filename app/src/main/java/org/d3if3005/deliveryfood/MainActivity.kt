package org.d3if3005.deliveryfood

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.d3if3005.deliveryfood.data.local.Category
import org.d3if3005.deliveryfood.data.local.Meal
import org.d3if3005.deliveryfood.data.model.UserData
import org.d3if3005.deliveryfood.databinding.ActivityMainBinding
import org.d3if3005.deliveryfood.ui.AboutFragment
//import org.d3if3005.deliveryfood.ui.HistoryRecipeFragment
import org.d3if3005.deliveryfood.utils.adapter.CategoryAdapter
import org.d3if3005.deliveryfood.utils.adapter.MealAdapter
import org.d3if3005.deliveryfood.utils.api.ApiUtils
import org.d3if3005.deliveryfood.utils.presenter.HomePresenter
import org.d3if3005.deliveryfood.views.HomeView
import org.d3if3005.deliveryfood.views.UserAdapter

class MainActivity : AppCompatActivity(), HomeView {
    private lateinit var presenter: HomePresenter
    private lateinit var binding: ActivityMainBinding
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var userList:ArrayList<UserData>
    private lateinit var userAdapter: UserAdapter

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }


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

        presenter = HomePresenter(this)

        with(presenter) {
            getMeals()
            getCategories()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.another_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
//            R.id.item1 -> {
//                val intent = Intent(this, HistoryRecipeFragment::class.java)
//                startActivity(intent)
//                return true
//            }
            R.id.item2 -> {
                this.startActivity(Intent(this,AboutFragment::class.java))
                return true
            }
            // Add more cases for other menu items if needed
            else -> return super.onOptionsItemSelected(item)
        }
    }

    @SuppressLint("NotifyDataSetChanged")

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