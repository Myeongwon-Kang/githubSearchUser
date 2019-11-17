package com.kang6264.githubsearchuser.data.repo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.data.remote.api.model.User
import io.reactivex.disposables.CompositeDisposable

class UserDataSourceFactory(private val compositeDisposable: CompositeDisposable,
                            private val query : String,
                            private val api: GithubApi) : DataSource.Factory<Int, User>(){

    val sourceLiveData = MutableLiveData<UserDataSource>()

    override fun create(): DataSource<Int, User> {
        val userDataSource =
            UserDataSource(compositeDisposable, query, api)
        sourceLiveData.postValue(userDataSource)
        return userDataSource
    }

}