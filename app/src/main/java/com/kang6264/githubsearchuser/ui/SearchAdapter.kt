package com.kang6264.githubsearchuser.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kang6264.githubsearchuser.base.BaseViewModel
import com.kang6264.githubsearchuser.data.remote.api.model.User
import com.kang6264.githubsearchuser.databinding.ItemSearchUserBinding

class SearchAdapter : PagedListAdapter<User, SearchAdapter.SearchViewHolder>(REPO_COMPARATOR){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind()
        }
    }

    class SearchViewHolder(val binding : ItemSearchUserBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(){
            binding.executePendingBindings()
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem.id == newItem.id
        }
    }
}