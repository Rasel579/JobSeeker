package com.test_app.jobseeker.models.cloud

import com.test_app.jobseeker.models.api.data.JobsDTO
import com.test_app.jobseeker.models.api.data.Result
import io.reactivex.rxjava3.core.Maybe

interface CloudDataSource {
    fun getJobs(searchValue: String?, page: Int) : Maybe<JobsDTO>
}