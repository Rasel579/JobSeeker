package com.test_app.jobseeker.models.cache

import androidx.room.*
import com.test_app.jobseeker.models.api.data.Category
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface JobsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertJob(job: Result) :Completable

    @Query("SELECT * FROM Result")
    fun getAll(): Single<List<Result>>
}