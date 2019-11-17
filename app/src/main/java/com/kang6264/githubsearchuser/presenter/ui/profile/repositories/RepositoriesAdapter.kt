package com.kang6264.githubsearchuser.presenter.ui.profile.repositories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kang6264.githubsearchuser.data.remote.api.model.Repos
import com.kang6264.githubsearchuser.databinding.RepositoriesItemBinding

class RepositoriesAdapter(val viewModel: RepositoriesViewModel) : PagedListAdapter<Repos, RepositoriesAdapter.ViewHolder>(
    REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RepositoriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class ViewHolder(val binding: RepositoriesItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(repo : Repos){
            binding.repo = repo
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Repos>() {
            override fun areItemsTheSame(oldItem: Repos, newItem: Repos): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Repos, newItem: Repos): Boolean =
                oldItem.id == newItem.id
        }
    }
}