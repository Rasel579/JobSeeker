package com.test_app.jobseeker.models

import com.test_app.jobseeker.models.api.data.JobsDTO
import com.test_app.jobseeker.models.api.data.Result
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface Repo {
    fun getJobs(searchVal : String?, page: Int): Observable<JobsDTO>
    fun addFav(result: Result): Single<Unit>
    fun getFavoriteJobs(): Single<List<Result>>

}