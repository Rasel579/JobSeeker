package com.test_app.jobseeker.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.test_app.jobseeker.R
import com.test_app.jobseeker.databinding.FragmentFavVacanciesBinding
import com.test_app.jobseeker.models.Repo
import com.test_app.jobseeker.models.api.data.Result
import com.test_app.jobseeker.presenters.FavVacanciesPresenter
import com.test_app.jobseeker.ui.daggerAbs.AbsFragment
import com.test_app.jobseeker.utils.schedulers.Schedulers
import com.test_app.jobseeker.view.FavVacanciesView
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class FavVacanciesFragment : AbsFragment(R.layout.fragment_fav_vacancies), FavVacanciesView {
    companion object {
        fun newInstance() = FavVacanciesFragment()
    }

    private val viewBinding: FragmentFavVacanciesBinding by viewBinding(CreateMethod.INFLATE)

    @Inject
    lateinit var repo: Repo

    @Inject
    lateinit var schedulers: Schedulers
    private val presenter by moxyPresenter {
        FavVacanciesPresenter(
            repo,
            schedulers
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setData(data: List<Result>) = with(viewBinding) {
        adapterFav.adapter = AdapterFavVacancies(data)

    }

    override fun showError(error: Throwable) {
        error.message?.let { Snackbar.make(viewBinding.root, it, Snackbar.LENGTH_SHORT).show() }
    }
}