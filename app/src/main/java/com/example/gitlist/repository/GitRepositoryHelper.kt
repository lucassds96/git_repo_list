package com.example.gitlist.repository

import com.example.gitlist.model.GitRepositories

interface GitRepositoryHelper {
    suspend fun getGitRepository(): GitRepositories
}