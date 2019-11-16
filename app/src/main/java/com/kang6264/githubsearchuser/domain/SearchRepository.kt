package com.kang6264.githubsearchuser.domain

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.kang6264.githubsearchuser.data.remote.api.model.PagedResult
import com.kang6264.githubsearchuser.data.remote.api.model.User
import com.kang6264.githubsearchuser.data.repo.UserDataSourceFactory
import io.reactivex.disposables.CompositeDisposable

class SearchRepository(val compositeDisposable: CompositeDisposable){
    private val config: PagedList.Config = PagedList.Config.Builder().apply {
        setInitialLoadSizeHint(20)
        setPageSize(20)
        setPrefetchDistance(5)
        setEnablePlaceholders(true)
    }.build()

    fun searchUsers(query: String): PagedResult<User> {
        val sourceFactory = UserDataSourceFactory(compositeDisposable, query)
        val livePagedList = LivePagedListBuilder(sourceFactory, config).build()
        return PagedResult(data = livePagedList)
    }
}