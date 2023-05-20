package org.d3if3005.deliveryfood.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.d3if3005.deliveryfood.R
import org.d3if3005.deliveryfood.databinding.FragmentAboutBinding
import org.d3if3005.deliveryfood.databinding.FragmentNewRecipeBinding


class NewRecipeFragment : AppCompatActivity() {
    private lateinit var binding: FragmentNewRecipeBinding

    override fun onCreate(savedInstanceState) {
        super.onCreate(savedInstanceState)
        binding = FragmentNewRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}