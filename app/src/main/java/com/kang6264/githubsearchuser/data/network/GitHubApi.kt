package com.kang6264.githubsearchuser.data.network

import com.kang6264.githubsearchuser.data.remote.api.model.Profile
import com.kang6264.githubsearchuser.data.remote.api.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi{
    @GET("/search/users")
    fun users(@Query(value = "q") query: String, @Query(value = "page") page: Int,
              @Query(value = "per_page") perPage: Int): Single<User.Result>

    @GET("/users/{user}")
    fun profile(@Path("user") query: String) : Single<Profile>
}