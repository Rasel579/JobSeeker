package com.test_app.jobseeker.view

import com.test_app.jobseeker.models.api.data.JobsDTO
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ItemVacancyView : MvpView{
    fun updateData(data : JobsDTO)
    fun showError(t: Throwable)
}