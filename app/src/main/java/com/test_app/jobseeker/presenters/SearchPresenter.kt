package com.test_app.jobseeker.presenters

import com.github.terrakok.cicerone.Router
import com.test_app.jobseeker.navigation.ViewPagerVacancyScreen
import com.test_app.jobseeker.view.SearchView
import moxy.MvpPresenter

class SearchPresenter(private val router: Router) : MvpPresenter<SearchView>() {
    fun searchEvent(searchVal: String?) {
        if (!searchVal.isNullOrBlank()) {
            router.navigateTo(ViewPagerVacancyScreen.create(searchVal), true)
        } else {
            viewState.showError("Empty String")
        }
    }

    override fun onFirstViewAttach() {
        viewState.setListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewState.showError("error")
    }

}