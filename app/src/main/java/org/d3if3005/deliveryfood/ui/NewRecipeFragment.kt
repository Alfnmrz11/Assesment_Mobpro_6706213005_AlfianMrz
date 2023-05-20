package org.d3if3005.deliveryfood.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import org.d3if3005.deliveryfood.R
import org.d3if3005.deliveryfood.databinding.FragmentAboutBinding
import org.d3if3005.deliveryfood.databinding.FragmentNewRecipeBinding


class NewRecipeFragment : Fragment() {
    private lateinit var binding: FragmentNewRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewRecipeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
}