package com.kang6264.githubsearchuser.domain

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.data.remote.api.model.PagedResult
import com.kang6264.githubsearchuser.data.remote.api.model.Repos
import com.kang6264.githubsearchuser.data.remote.api.model.Starred
import com.kang6264.githubsearchuser.data.remote.api.model.User
import com.kang6264.githubsearchuser.data.repo.UserDataSourceFactory
import com.kang6264.githubsearchuser.data.repo.UserReposDataSourceFactory
import com.kang6264.githubsearchuser.data.repo.UserStarredDataSourceFactory
import io.reactivex.disposables.CompositeDisposable

class SearchRepository(private val compositeDisposable: CompositeDisposable,
                       private val api: GithubApi){

    private val config: PagedList.Config = PagedList.Config.Builder().apply {
        setInitialLoadSizeHint(20)
        setPageSize(20)
        setPrefetchDistance(5)
        setEnablePlaceholders(true)
    }.build()

    fun searchUsers(query: String): PagedResult<User> {
        val sourceFactory = UserDataSourceFactory(compositeDisposable, query, api)
        val livePagedList = LivePagedListBuilder(sourceFactory, config).build()
        return PagedResult(data = livePagedList)
    }

    fun searchUserRepos(query: String): PagedResult<Repos>{
        val sourceFactory = UserReposDataSourceFactory(compositeDisposable, query, api)
        val livePagedList = LivePagedListBuilder(sourceFactory, config).build()
        return PagedResult(data = livePagedList)
    }

    fun searchUserStarred(query: String): PagedResult<Starred>{
        val sourceFactory = UserStarredDataSourceFactory(compositeDisposable, query, api)
        val livePagedList = LivePagedListBuilder(sourceFactory, config).build()
        return PagedResult(data = livePagedList)
    }
}