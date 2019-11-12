package com.kang6264.githubsearchuser.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kang6264.githubsearchuser.R
import com.kang6264.githubsearchuser.databinding.ActivityMainBinding
import com.kang6264.githubsearchuser.network.GithubApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private val adapter = SearchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        searchResultRecyclerView.adapter = adapter

        viewModel.pagedList.observe(this, Observer {
            adapter.submitList(it)
        })

        /*
        GithubApi.retrofitService.users("android", 1, 10)
            .subscribe({
                adapter.submitList(it.items)
            }, {
                val temp = ""
            })
            */
    }
}
