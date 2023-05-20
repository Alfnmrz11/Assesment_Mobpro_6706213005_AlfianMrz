package org.d3if3005.deliveryfood.utils.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3005.deliveryfood.databinding.FragmentListItemNewRecipeBinding
import org.d3if3005.deliveryfood.db.RecipeEntity


class HistoryAdapter : ListAdapter<RecipeEntity, HistoryAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<RecipeEntity>() {
                override fun areItemsTheSame(
                    oldData: RecipeEntity, newData: RecipeEntity
                ): Boolean {
                    return oldData.id == newData.id
                }
                override fun areContentsTheSame(
                    oldData: RecipeEntity, newData: RecipeEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }
    class ViewHolder(
        private val binding: FragmentListItemNewRecipeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
