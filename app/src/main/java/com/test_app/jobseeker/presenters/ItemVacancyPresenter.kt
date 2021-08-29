package com.test_app.jobseeker.presenters

import android.util.Log
import com.test_app.jobseeker.models.Repo
import com.test_app.jobseeker.models.api.data.Result
import com.test_app.jobseeker.ui.ViewPagerVacancy
import com.test_app.jobseeker.utils.schedulers.Schedulers
import com.test_app.jobseeker.view.ItemVacancyView
import com.test_app.jobseeker.view.VacancyView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter

class ItemVacancyPresenter(
    private val repo: Repo,
    private val schedulers: Schedulers
) : MvpPresenter<ItemVacancyView>() {
    private val disposable = CompositeDisposable()
    fun addFavoriteVacancy(result: Result) {
        disposable += repo.addFav(result).
        observeOn(schedulers.main())
            .subscribe({
                Log.e("Success Room", it.toString())
            }, {
                Log.e("Fail Room", it.message.toString())
            })
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}