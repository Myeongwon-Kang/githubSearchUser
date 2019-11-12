package com.kang6264.githubsearchuser.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.kang6264.githubsearchuser.data.remote.api.model.User
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.github.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(
        GsonConverterFactory
            .create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
    .baseUrl(BASE_URL)
    .build()

interface GithubApiService{
    @GET("/search/users")
    fun users(@Query(value = "q") query: String, @Query(value = "page") page: Int, @Query(value = "per_page") perPage: Int): Single<User.Result>
}

object GithubApi {
    val retrofitService : GithubApiService by lazy { retrofit.create(GithubApiService::class.java) }
}