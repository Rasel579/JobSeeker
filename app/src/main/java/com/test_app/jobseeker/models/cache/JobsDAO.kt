package com.test_app.jobseeker.models.cache

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface JobsDAO {
    @Insert
    fun insertJob(job: Result): Completable

    @Query("SELECT * FROM Result")
    fun getAll(): Single<List<Result>>

    @Query("SELECT * FROM result WHERE title = :title ")
    fun  find(title : String) : Single<Result>

    @Delete
    fun delete(job: Result): Completable
}