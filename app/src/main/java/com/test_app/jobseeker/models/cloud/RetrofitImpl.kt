package com.test_app.jobseeker.models.cloud

import com.test_app.jobseeker.models.api.ServiceApi
import com.test_app.jobseeker.models.api.data.JobsDTO
import com.test_app.jobseeker.utils.schedulers.Schedulers
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

class RetrofitImpl @Inject constructor(
    private val api: ServiceApi,
    private val schedulers: Schedulers
) : CloudDataSource {
    override fun getJobs(searchValue: String?, page: Int): Maybe<JobsDTO> =
        api.seekJobs(page, searchValue)
            .subscribeOn(schedulers.io())

}