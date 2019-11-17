package com.kang6264.githubsearchuser.data.remote.api.model.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.kang6264.githubsearchuser.data.network.GithubApi
import com.kang6264.githubsearchuser.domain.ProfileRepository
import com.kang6264.githubsearchuser.domain.ProfileRepositoryImpl
import com.kang6264.githubsearchuser.domain.ReposRepository
import com.kang6264.githubsearchuser.presenter.ui.MainViewModel
import com.kang6264.githubsearchuser.presenter.ui.profile.overview.OverViewViewModel
import com.kang6264.githubsearchuser.presenter.ui.profile.repositories.RepositoriesViewModel
import com.kang6264.githubsearchuser.presenter.ui.profile.starred.StarredViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.github.com"

val netWorkModule = module {
    single {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(
                GsonConverterFactory
                    .create()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .baseUrl(BASE_URL)
            .build()
            .create(GithubApi::class.java)
    }

    factory {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()
    }
}

val appModule = module {
    factory { CompositeDisposable() }
}

val myModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { OverViewViewModel(get()) }
    viewModel { RepositoriesViewModel(get()) }
    viewModel { StarredViewModel(get()) }

    single<ProfileRepository> { ProfileRepositoryImpl(get(), get()) }
}

val modules = listOf(netWorkModule, myModule, appModule)