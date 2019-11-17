package com.kang6264.githubsearchuser.data.repo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.data.remote.api.model.Repos
import com.kang6264.githubsearchuser.data.remote.api.model.Starred
import io.reactivex.disposables.CompositeDisposable

class UserStarredDataSourceFactory (private val compositeDisposable: CompositeDisposable,
                                    private val query : String,
                                    private val api: GithubApi
) : DataSource.Factory<Int, Starred>(){

    val sourceLiveData = MutableLiveData<UserStarredDataSource>()

    override fun create(): DataSource<Int, Starred> {
        val userDataSource =
            UserStarredDataSource(compositeDisposable, query, api)
        sourceLiveData.postValue(userDataSource)
        return userDataSource
    }
}