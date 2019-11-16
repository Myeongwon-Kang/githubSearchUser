package com.kang6264.githubsearchuser.data.repo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.kang6264.githubsearchuser.data.remote.api.model.User
import io.reactivex.disposables.CompositeDisposable

class UserDataSourceFactory(val compositeDisposable: CompositeDisposable, val query : String) : DataSource.Factory<Int, User>(){

    val sourceLiveData = MutableLiveData<UserDataSource>()

    override fun create(): DataSource<Int, User> {
        val userDataSource =
            UserDataSource(compositeDisposable, query)
        sourceLiveData.postValue(userDataSource)
        return userDataSource
    }

}