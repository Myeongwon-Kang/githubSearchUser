package com.kang6264.githubsearchuser.presenter.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.kang6264.githubsearchuser.data.remote.api.model.PagedResult
import com.kang6264.githubsearchuser.data.remote.api.model.User
import com.kang6264.githubsearchuser.domain.SearchRepository
import io.reactivex.disposables.CompositeDisposable

class MainViewModel : ViewModel(){

    val compositeDisposable = CompositeDisposable()

    private val repository = SearchRepository(compositeDisposable)
    private val result = MutableLiveData<PagedResult<User>>()
    val pagedList : LiveData<PagedList<User>> = Transformations.switchMap(result){it.data}

    init {
        Log.i("MainViewModel", "MainViewModel create")
    }

    fun onClickSearchUser(query : String){
        repository.searchUsers("")
        query
            ?.takeIf { it.isNotEmpty() }
            ?.let { result.postValue(repository.searchUsers(it)) }

    }
}