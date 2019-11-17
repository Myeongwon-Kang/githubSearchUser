package com.kang6264.githubsearchuser.presenter.ui.profile.starred

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.kang6264.githubsearchuser.R
import kotlinx.android.synthetic.main.starred_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class StarredFragment : Fragment() {

    companion object {
        fun newInstance(login: String?) : StarredFragment {
            return StarredFragment().apply {
                arguments = Bundle().apply {
                    putString("login", login)
                }
            }
        }
    }

    //private lateinit var viewModel: StarredViewModel
    val viewModel by viewModel<StarredViewModel>()

    private val adapter by lazy {
        StarredAdapter(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.starred_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(StarredViewModel::class.java)
        recyclerView.adapter = adapter
        viewModel.pagedList.observe(this, Observer {
            adapter.submitList(it)
        })

        arguments?.getString("login")?.let {
            viewModel.searchUserStarred(it)
        }
    }

}
