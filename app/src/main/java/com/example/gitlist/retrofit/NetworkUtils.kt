package com.example.gitlist.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkUtils {
    private const val URL_API = "https://api.github.com/search/repositories?q=language:kotlin&sort=stars&page%20=1"

    private fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: Api = getRetrofitInstance().create(Api::class.java)
}