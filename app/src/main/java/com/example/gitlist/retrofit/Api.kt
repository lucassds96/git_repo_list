package com.example.gitlist.retrofit

import com.example.gitlist.model.GitRepositories
import retrofit2.http.GET

interface Api {
    @GET("repositories?q=language:kotlin&sort=stars&page%20=1")
    suspend fun getRepo(): GitRepositories
}