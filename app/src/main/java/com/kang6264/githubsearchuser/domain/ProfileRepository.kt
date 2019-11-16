package com.kang6264.githubsearchuser.domain

import androidx.lifecycle.MutableLiveData
import com.kang6264.githubsearchuser.data.remote.api.model.Profile

interface ProfileRepository {
    fun searchProfile(login: String, profile: MutableLiveData<Profile>)
}