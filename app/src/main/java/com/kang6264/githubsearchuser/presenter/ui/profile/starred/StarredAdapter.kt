package com.kang6264.githubsearchuser.presenter.ui.profile.starred

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kang6264.githubsearchuser.data.remote.api.model.Repos
import com.kang6264.githubsearchuser.data.remote.api.model.Starred
import com.kang6264.githubsearchuser.databinding.RepositoriesItemBinding
import com.kang6264.githubsearchuser.databinding.StarredItemBinding

class StarredAdapter(val viewModel: StarredViewModel) : PagedListAdapter<Starred, StarredAdapter.ViewHolder>(
    REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StarredItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class ViewHolder(val binding: StarredItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(starred: Starred){
            binding.starred = starred
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Starred>() {
            override fun areItemsTheSame(oldItem: Starred, newItem: Starred): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Starred, newItem: Starred): Boolean =
                oldItem.id == newItem.id
        }
    }
}