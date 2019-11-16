package com.kang6264.githubsearchuser.data.remote.api.model

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

open class PagedResult<T>(var data: LiveData<PagedList<T>>)