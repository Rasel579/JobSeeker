package com.test_app.jobseeker.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution
@StateStrategyType(AddToEndSingleStrategy::class)
interface SearchView : MvpView {
    fun setListener()
    fun showError(msg: String)
    fun setMenu()
    fun showFilter()
    fun hideFilter()
}