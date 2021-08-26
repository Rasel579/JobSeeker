package com.test_app.jobseeker.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test_app.jobseeker.databinding.ItemVacancyLayoutBinding
import com.test_app.jobseeker.models.api.data.JobsDTO
import com.test_app.jobseeker.models.api.data.Result

class ViewPagerAdapter(
    private val data: JobsDTO
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolderVacancy>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderVacancy =
        ViewHolderVacancy(
            ItemVacancyLayoutBinding
                .inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
        )

    override fun onBindViewHolder(holder: ViewHolderVacancy, position: Int) {
        holder.setData(data.results, position)
    }

    override fun getItemCount(): Int = data.results.size

    inner class ViewHolderVacancy(
        private val binding: ItemVacancyLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setData(results: List<Result>, position: Int) {
            binding.companyName.text = results[position].company.displayName
            binding.role.text = results[position].title
            binding.text.text = results[position].description
        }

    }
}
