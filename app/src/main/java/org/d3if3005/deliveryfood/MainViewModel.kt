package org.d3if3005.deliveryfood

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3005.deliveryfood.data.model.UserData

class MainViewModel : ViewModel() {
    private val UserData = MutableLiveData<UserData?>()
    fun newRecipe(title: String, intruction: String, ingredient: String): MutableLiveData<UserData?> {
        return UserData
    }
}