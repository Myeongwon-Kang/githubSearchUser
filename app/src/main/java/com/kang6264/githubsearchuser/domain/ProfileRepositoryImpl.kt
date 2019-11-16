package com.kang6264.githubsearchuser.domain

import androidx.lifecycle.MutableLiveData
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.data.remote.api.model.Profile
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProfileRepositoryImpl(val compositeDisposable: CompositeDisposable,
                            val api: GithubApi) : ProfileRepository {

    override fun searchProfile(login: String, profile: MutableLiveData<Profile>) {
        compositeDisposable.add(
            api.profile(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    profile.postValue(it)
                }, {
                    it.cause
                })
        )
    }
}