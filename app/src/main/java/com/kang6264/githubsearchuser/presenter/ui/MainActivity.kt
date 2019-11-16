package com.kang6264.githubsearchuser.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kang6264.githubsearchuser.R
import com.kang6264.githubsearchuser.databinding.ActivityMainBinding
import com.kang6264.githubsearchuser.presenter.ui.search.SearchAdapter
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
    }

    inner class ActionListener : SearchView.OnQueryTextListener{
        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }

        override fun onQueryTextSubmit(query: String?): Boolean {
            query?.let { viewModel.onClickSearchUser(it) }
            return true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //menuInflater.inflate(R.menu.menu_search, menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)

        val menuItem = menu?.findItem(R.id.menu_main_search)

        var searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(ActionListener())

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        //val inflater = menuInflater
        //inflater.inflate(R.)
    }
}
