package com.example.gitlist.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitlist.repository.GitRepositoryHelper
import com.example.gitlist.ui.home.HomeViewModel

class ViewModelFactory (private val gitRepositoryHelper: GitRepositoryHelper) :
    ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(gitRepositoryHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}