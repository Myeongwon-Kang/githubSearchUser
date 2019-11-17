package com.kang6264.githubsearchuser.presenter.ui.profile.starred

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.data.remote.api.model.PagedResult
import com.kang6264.githubsearchuser.data.remote.api.model.Repos
import com.kang6264.githubsearchuser.data.remote.api.model.Starred
import com.kang6264.githubsearchuser.data.remote.api.model.User
import com.kang6264.githubsearchuser.domain.SearchRepository
import io.reactivex.disposables.CompositeDisposable

class StarredViewModel(api: GithubApi) : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    private val repository = SearchRepository(compositeDisposable, api)
    private val result = MutableLiveData<PagedResult<Starred>>()
    val pagedList : LiveData<PagedList<Starred>> = Transformations.switchMap(result){it.data}

    fun searchUserStarred(query : String){
        result.postValue(repository.searchUserStarred(query))
    }
}
