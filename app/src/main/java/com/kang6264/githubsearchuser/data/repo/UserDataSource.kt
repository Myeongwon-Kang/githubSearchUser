package com.kang6264.githubsearchuser.data.repo

import androidx.paging.PageKeyedDataSource
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.data.remote.api.model.User
import io.reactivex.disposables.CompositeDisposable

class UserDataSource(val compositeDisposable: CompositeDisposable,
                     val query: String,
                     val api : GithubApi) :
    PageKeyedDataSource<Int, User>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>
    ) {
        compositeDisposable.add(
            api.users(query, 1, params.requestedLoadSize)
                .map { it.items }
                .subscribe({
                    callback.onResult(it, null, 2)
                }, {
                    callback.onResult(emptyList(), null, null)
                })
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        compositeDisposable.add(
            api.users(query, params.key, params.requestedLoadSize)
                .map { it.items }
                .subscribe({
                    callback.onResult(it, params.key.plus(1))
                }, {

                })
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {

    }

}