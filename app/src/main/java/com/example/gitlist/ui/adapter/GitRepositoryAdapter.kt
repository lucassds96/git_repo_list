package com.example.gitlist.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gitlist.R
import com.example.gitlist.model.GitRepositories
import kotlinx.android.synthetic.main.item_repositories.view.*

class GitRepositoryAdapter(val context: Context, val listRepositories: List<GitRepositories>) : RecyclerView.Adapter<GitRepositoryAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepositoryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repositories, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(list: GitRepositories){
            Glide.with(context).load(list.items[adapterPosition].owner[adapterPosition].avatar_url).into(itemView.userAvatar)
            itemView.name.text = list.items[adapterPosition].name
            itemView.repoName.text = list.items[adapterPosition].owner[adapterPosition].login
            itemView.stars.text = list.items[adapterPosition].name
            itemView.numberForks.text = list.forks_count.toString()
        }
    }

    override fun onBindViewHolder(holder: GitRepositoryAdapter.ViewHolder, position: Int) = holder.bind(listRepositories[position])

    override fun getItemCount(): Int = listRepositories.size

}