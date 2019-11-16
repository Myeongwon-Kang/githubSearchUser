package com.kang6264.githubsearchuser.presenter.ui.profile

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.data.remote.api.model.Profile
import com.kang6264.githubsearchuser.domain.ProfileRepository
import com.kang6264.githubsearchuser.domain.SearchRepository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class OverViewViewModel(val repo : ProfileRepository) : ViewModel() {

    var observableName = ObservableField<String>()
    var observableBio = ObservableField<String>()

    val profile = MutableLiveData<Profile>()

    fun searchUserProfile(login : String){
        repo.searchProfile(login, profile)
    }
}
