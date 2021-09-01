package com.test_app.jobseeker.view

import com.test_app.jobseeker.models.api.data.Result
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface FavVacanciesView : MvpView {
    fun setData(data: List<Result>)
    fun showError(error: Throwable)
}