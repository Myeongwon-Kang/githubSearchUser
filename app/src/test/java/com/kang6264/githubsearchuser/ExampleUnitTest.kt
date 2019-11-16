package com.kang6264.githubsearchuser

import androidx.lifecycle.MutableLiveData
import com.kang6264.githubsearchuser.data.remote.api.model.Profile
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.test.KoinTest

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest : KoinTest{

    val testLiveData = MutableLiveData<Profile>()

    @Before
    fun before(){
        startKoin {
            modules(com.kang6264.githubsearchuser.data.remote.api.model.network.modules)
        }
    }

    @Test
    fun testKoin(){

    }

}
