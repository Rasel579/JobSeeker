package com.test_app.jobseeker.presenters

import com.test_app.jobseeker.models.Repo
import com.test_app.jobseeker.utils.schedulers.Schedulers
import com.test_app.jobseeker.view.FavVacanciesView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter

class FavVacanciesPresenter(
    private val repo: Repo,
    private val schedulers: Schedulers
    ): MvpPresenter<FavVacanciesView>() {
    private val disposable = CompositeDisposable()
    override fun onFirstViewAttach() {
        disposable += repo.getFavoriteJobs().observeOn(schedulers.main()).subscribe(
            viewState::setData,
            viewState::showError
        )
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}