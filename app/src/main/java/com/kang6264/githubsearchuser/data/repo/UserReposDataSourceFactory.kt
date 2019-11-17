package com.kang6264.githubsearchuser.data.repo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.data.remote.api.model.Repos
import com.kang6264.githubsearchuser.data.remote.api.model.User
import io.reactivex.disposables.CompositeDisposable

class UserReposDataSourceFactory(val compositeDisposable: CompositeDisposable,
                                 val query : String,
                                 val api: GithubApi) : DataSource.Factory<Int, Repos>(){

    val sourceLiveData = MutableLiveData<UserReposDataSource>()

    override fun create(): DataSource<Int, Repos> {
        val userDataSource =
            UserReposDataSource(compositeDisposable, query, api)
        sourceLiveData.postValue(userDataSource)
        return userDataSource
    }
}