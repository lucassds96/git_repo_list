package com.example.gitlist.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitlist.model.GitRepositories
import com.example.gitlist.repository.GitRepositoryHelper

import com.example.gitlist.util.Resource
import kotlinx.coroutines.launch

class HomeViewModel(val apiHelper: GitRepositoryHelper): ViewModel() {

    private val showRepo = MutableLiveData<Resource<List<GitRepositories>>>()

    init {
        repoData()
    }

    private fun repoData(){
        viewModelScope.launch{
            try {
                val repoFromApi = apiHelper.getGitRepository()
                showRepo.postValue(Resource.success(repoFromApi))
            }catch (e: Exception){
                showRepo.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getRepositories(): LiveData<Resource<List<GitRepositories>>> {
        return showRepo
    }
}