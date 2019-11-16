package com.kang6264.githubsearchuser.presenter.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.data.remote.api.model.PagedResult
import com.kang6264.githubsearchuser.data.remote.api.model.User
import com.kang6264.githubsearchuser.domain.SearchRepository
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(val api: GithubApi) : ViewModel(){

    val compositeDisposable = CompositeDisposable()

    val profileLogin = MutableLiveData<String>()

    private val repository = SearchRepository(compositeDisposable, api)
    private val result = MutableLiveData<PagedResult<User>>()
    val pagedList : LiveData<PagedList<User>> = Transformations.switchMap(result){it.data}

    fun onClickSearchUser(query : String){
        query
            ?.takeIf { it.isNotEmpty() }
            ?.let { result.postValue(repository.searchUsers(it)) }

    }

    fun onClickUser(login : String){
        profileLogin.postValue(login)
    }


}