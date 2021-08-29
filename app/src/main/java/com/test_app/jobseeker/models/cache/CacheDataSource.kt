package com.test_app.jobseeker.models.cache

import com.test_app.jobseeker.models.api.data.Result
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single

interface CacheDataSource {
    fun insert(result: Result): Single<Unit>
    fun getAll(): Single<List<com.test_app.jobseeker.models.cache.Result>>
}