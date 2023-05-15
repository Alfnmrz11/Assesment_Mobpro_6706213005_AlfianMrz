package org.d3if3005.recipeapp.utils.presenter

import android.util.Log
import org.d3if3005.recipeapp.data.model.Meals
import org.d3if3005.recipeapp.utils.api.ApiUtils
import org.d3if3005.recipeapp.views.DetailView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter(private val view: DetailView) {
    fun getMealByName(mealName: String) {
        val call = ApiUtils().getAPI().getMealByName(mealName)

        call.enqueue(object : Callback<Meals> {
            override fun onResponse(call: Call<Meals>, response: Response<Meals>) {
                if (response.isSuccessful && response.body() != null)
                    view.setMeal(response.body()!!.meals[0])
                else view.onErrorLoading(response.message())
            }

            override fun onFailure(call: Call<Meals>, t: Throwable) {
                view.onErrorLoading(t.localizedMessage)

                Log.i(
                    "DetailPresenter.meals",
                    "Failed! ${t.message} --- ${t.printStackTrace()}"
                )
            }
        })
    }
}