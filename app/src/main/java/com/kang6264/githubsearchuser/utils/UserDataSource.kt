package com.kang6264.githubsearchuser.utils

import androidx.paging.PageKeyedDataSource
import com.kang6264.githubsearchuser.data.remote.api.model.User
import com.kang6264.githubsearchuser.network.GithubApi
import com.kang6264.githubsearchuser.network.GithubApiService

class UserDataSource(val query : String) : PageKeyedDataSource<Int, User>(){

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>
    ) {
        GithubApi.retrofitService.users(query, 1, params.requestedLoadSize)
            .map { it.items }
            .subscribe({
                callback.onResult(it, null, 2)
            }, {
                val temp = ""
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {

    }

}