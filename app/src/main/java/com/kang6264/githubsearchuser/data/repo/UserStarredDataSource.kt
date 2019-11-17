package com.kang6264.githubsearchuser.data.repo

import androidx.paging.PageKeyedDataSource
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.data.remote.api.model.Repos
import com.kang6264.githubsearchuser.data.remote.api.model.Starred
import com.kang6264.githubsearchuser.data.remote.api.model.User
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserStarredDataSource(val compositeDisposable: CompositeDisposable,
                            val query: String,
                            val api : GithubApi) :
    PageKeyedDataSource<Int, Starred>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Starred>
    ) {
        compositeDisposable.add(
            api.starred(query, 1, params.requestedLoadSize)
                .subscribe({
                    callback.onResult(it, null, 2)
                }, {
                    callback.onResult(emptyList(), null, null)
                })
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Starred>) {
        compositeDisposable.add(
            api.starred(query, params.key, params.requestedLoadSize)
                .subscribe({
                    callback.onResult(it, params.key.plus(1))
                }, {

                })
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Starred>) {

    }

}