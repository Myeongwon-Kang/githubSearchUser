package com.kang6264.githubsearchuser.presenter.ui.profile.repositories

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.kang6264.githubsearchuser.R
import kotlinx.android.synthetic.main.repositories_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoriesFragment : Fragment() {

    companion object {
        fun newInstance(login: String?) : RepositoriesFragment{
            return RepositoriesFragment().apply {
                arguments = Bundle().apply {
                    putString("login", login)
                }
            }
        }
    }

    //private lateinit var viewModel: RepositoriesViewModel
    val viewModel by viewModel<RepositoriesViewModel>()

    private val adapter by lazy {
        RepositoriesAdapter(viewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repositories_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(RepositoriesViewModel::class.java)
        recyclerView.adapter = adapter
        viewModel.pagedList.observe(this, Observer {
            adapter.submitList(it)
        })

        arguments?.getString("login")?.let {
            viewModel.searchUserRepos(it)
        }
    }
}
