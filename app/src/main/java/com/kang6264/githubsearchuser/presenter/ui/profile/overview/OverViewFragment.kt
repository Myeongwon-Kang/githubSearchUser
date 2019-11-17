package com.kang6264.githubsearchuser.presenter.ui.profile.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

import com.kang6264.githubsearchuser.databinding.OverViewFragmentBinding

class OverViewFragment : Fragment() {

    val viewModel by viewModel<OverViewViewModel>()
    var binding : OverViewFragmentBinding? = null

    companion object {
        fun newInstance(login: String?) : OverViewFragment {
            return OverViewFragment().apply {
                arguments = Bundle().apply {
                    putString("login", login)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getString("login")?.let { viewModel.searchUserProfile(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OverViewFragmentBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel
        return binding?.root
        //return inflater.inflate(R.layout.over_view_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(OverViewViewModel::class.java)

        viewModel.profile.observe(this, Observer {
            viewModel.observableName.set(it.name)
            viewModel.observableBio.set(it.bio.toString())
            binding?.profile?.setImageURI(it.avatar_url)
            //viewModel.observableAvatarUrl.set(it.avatar_url)
        })
    }

}
