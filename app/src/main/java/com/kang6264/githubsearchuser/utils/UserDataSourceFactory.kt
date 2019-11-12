package com.kang6264.githubsearchuser.utils

import androidx.paging.DataSource
import com.kang6264.githubsearchuser.data.remote.api.model.User

class UserDataSourceFactory(val query : String) : DataSource.Factory<Int, User>(){
    override fun create(): DataSource<Int, User> {
        return UserDataSource(query)
    }

}