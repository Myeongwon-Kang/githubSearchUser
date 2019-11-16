package com.kang6264.githubsearchuser

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)

        startKoin {
            androidContext(this@MyApplication)
            modules(com.kang6264.githubsearchuser.data.remote.api.model.network.modules)
        }
    }
}