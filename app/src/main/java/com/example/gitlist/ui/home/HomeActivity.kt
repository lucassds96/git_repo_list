package com.example.gitlist.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitlist.R
import com.example.gitlist.model.GitRepositories
import com.example.gitlist.repository.GitRepositoryImpl
import com.example.gitlist.retrofit.NetworkUtils
import com.example.gitlist.ui.adapter.GitRepositoryAdapter
import com.example.gitlist.util.Status
import com.example.gitlist.util.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    lateinit var adapterGit: GitRepositoryAdapter
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeViewModel = ViewModelProvider(this, ViewModelFactory(
            GitRepositoryImpl(NetworkUtils.apiService))
        ).get(HomeViewModel::class.java)
        setObservers()
    }

    fun setObservers(){
        homeViewModel.run {
            homeViewModel.getRepositories().observe(this@HomeActivity, Observer {
                when(it.status){
                    Status.SUCCESS -> { it.data?.let { initRepo(it) }}
                    Status.ERROR -> {errorApi(it.message!!)}
                }
            })
        }
    }

    fun initRepo(list: GitRepositories){
        adapterGit = GitRepositoryAdapter(this, list)
        repoList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        repoList.adapter = adapterGit
    }

    fun errorApi(error: String){
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
}