package org.d3if3005.deliveryfood.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if3005.deliveryfood.db.RecipeDb
import org.d3if3005.deliveryfood.ui.factory.HistoryViewModelFactory
import org.d3if3005.deliveryfood.views.HistoryViewModel

//class HistoryRecipeFragment : Fragment() {
//    private lateinit var binding: HistoryRecipeFragmentBinding
//
//    private val viewModel: HistoryViewModel by lazy {
//        val db = RecipeDb.getInstance(requireContext())
//        val factory = HistoryViewModelFactory(db.dao)
//        ViewModelProvider(this)[HistoryViewModel::class.java]
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle
//    ): View? {
//        binding = HistoryRecipeFragmentBinding.inflate(layoutInflater,
//            container, false)
//        return binding.root
//    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        viewModel.data.observe(viewLifecycleOwner, {
//            Log.d("HistoriFragment", "Jumlah data: ${it.size}")
//        })
//    }
//}