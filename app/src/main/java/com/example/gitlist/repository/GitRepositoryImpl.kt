package com.example.gitlist.repository

import com.example.gitlist.retrofit.Api

class GitRepositoryImpl(private val api: Api): GitRepositoryHelper {
    override fun getGitRepository() = api.getRepo()
}