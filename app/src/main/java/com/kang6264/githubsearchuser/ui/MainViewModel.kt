package com.kang6264.githubsearchuser.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.kang6264.githubsearchuser.data.remote.api.model.User
import com.kang6264.githubsearchuser.utils.UserDataSourceFactory

class MainViewModel : ViewModel(){

    private val config: PagedList.Config = PagedList.Config.Builder().apply {
        setInitialLoadSizeHint(20)
        setPageSize(20)
        setPrefetchDistance(5)
        setEnablePlaceholders(true)
    }.build()

   val pagedList : LiveData<PagedList<User>> = LivePagedListBuilder(UserDataSourceFactory("android"), config).build()

    init {
        Log.i("MainViewModel", "MainViewModel create")
    }
}