package com.test_app.jobseeker.view

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface SearchView : MvpView {
    fun showError(msg: String)
    fun setListener()
}