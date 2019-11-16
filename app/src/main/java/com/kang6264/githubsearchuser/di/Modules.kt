package com.kang6264.githubsearchuser.data.remote.api.model.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.domain.ProfileRepository
import com.kang6264.githubsearchuser.domain.ProfileRepositoryImpl
import com.kang6264.githubsearchuser.presenter.ui.MainViewModel
import com.kang6264.githubsearchuser.presenter.ui.profile.OverViewViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.github.com"

val netWorkModule = module {
    single {
        Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory
                    .create()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .baseUrl(BASE_URL)
            .build()
            .create(GithubApi::class.java)
    }
}

val appModule = module {
    factory { CompositeDisposable() }
}

val myModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { OverViewViewModel(get()) }

    single<ProfileRepository> { ProfileRepositoryImpl(get(), get()) }
}

val modules = listOf(netWorkModule, myModule, appModule)