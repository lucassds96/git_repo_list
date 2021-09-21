package com.example.gitlist.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitlist.R
import com.example.gitlist.model.GitRepositories
import com.example.gitlist.model.OwnerDetails
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_repositories.view.*

class GitRepositoryAdapter(val context: Context, val listRepositories: GitRepositories) : RecyclerView.Adapter<GitRepositoryAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepositoryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repositories, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(list: OwnerDetails){

            Picasso.with(context).load(list.owner.avatar_url).into(itemView.userAvatar)
            itemView.name.text = list.name
            itemView.repoName.text = list.owner.login
            itemView.stars.text = list.name
            itemView.numberForks.text = list.forks_count.toString()
        }
    }

    override fun onBindViewHolder(holder: GitRepositoryAdapter.ViewHolder, position: Int) = holder.bind(listRepositories.items[position])

    override fun getItemCount(): Int = listRepositories.items.size

}