package com.example.gitlist.retrofit

import com.example.gitlist.model.GitRepositories
import retrofit2.http.GET

interface Api {
    @GET("")
    fun getRepo(): List<GitRepositories>
}