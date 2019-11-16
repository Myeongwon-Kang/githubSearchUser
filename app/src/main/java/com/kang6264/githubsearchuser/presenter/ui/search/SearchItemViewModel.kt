package com.kang6264.githubsearchuser.presenter.ui.search

import androidx.databinding.ObservableField
import com.kang6264.githubsearchuser.data.remote.api.model.User

class SearchItemViewModel(val user : User){
    var photoUrl: ObservableField<String?>? = ObservableField()

}