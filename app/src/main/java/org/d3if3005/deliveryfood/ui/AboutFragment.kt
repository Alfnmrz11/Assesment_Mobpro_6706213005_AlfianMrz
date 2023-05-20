package org.d3if3005.deliveryfood.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.d3if3005.deliveryfood.R
import org.d3if3005.deliveryfood.databinding.FragmentAboutBinding


class AboutFragment : AppCompatActivity() {
    private lateinit var binding: FragmentAboutBinding

    override fun onCreate(savedInstanceState) {
        super.onCreate(savedInstanceState)
        binding = FragmentAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}