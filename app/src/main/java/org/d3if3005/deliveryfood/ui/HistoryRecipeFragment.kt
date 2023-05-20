package org.d3if3005.deliveryfood.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment

class HistoryRecipeFragment : Fragment() {
    private lateinit var binding: HistoryRecipeFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle
    ): View? {
        binding = HistoryRecipeFragmentBinding.inflate(layoutInflater,
            container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.data.observe(viewLifecycleOwner, {
            Log.d("HistoriFragment", "Jumlah data: ${it.size}")
        })
    }

}