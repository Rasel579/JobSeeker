package com.test_app.jobseeker.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test_app.jobseeker.databinding.ItemFavoriteVacancyBinding
import com.test_app.jobseeker.models.api.data.Result

class AdapterFavVacancies(
    private val data: List<Result>,
) : RecyclerView.Adapter<AdapterFavVacancies.ItemFavVacancies>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFavVacancies =
        ItemFavVacancies(
            ItemFavoriteVacancyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemFavVacancies, position: Int) {
        holder.setData(data, position)
    }

    override fun getItemCount(): Int = data.size

    inner class ItemFavVacancies(
        private val binding: ItemFavoriteVacancyBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setData(data: List<Result>, position: Int) {
            binding.companyName.text = data[position].company.displayName
            binding.role.text = data[position].title
            binding.text.text = data[position].description
            binding.location.text = data[position].location.displayLocation
        }

    }
}