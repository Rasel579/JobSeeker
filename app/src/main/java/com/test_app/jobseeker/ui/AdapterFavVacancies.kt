package com.test_app.jobseeker.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test_app.jobseeker.databinding.ItemFavoriteVacancyBinding
import com.test_app.jobseeker.models.api.data.Result
import com.test_app.jobseeker.presenters.FavVacanciesPresenter

class AdapterFavVacancies(
    private val data: List<Result>,
    private val presenter: FavVacanciesPresenter,
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
        fun setData(data: List<Result>, position: Int)= with(binding) {
            companyName.text = data[position].company.displayName
            role.text = data[position].title
            text.text = data[position].description
            location.text = data[position].location.displayLocation
            deleteBtn.setOnClickListener {
                presenter.deleteJob(data[position])
            }
        }

    }
}