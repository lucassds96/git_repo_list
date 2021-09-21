package com.example.gitlist.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.gitlist.model.GitRepositories
import com.example.gitlist.repository.GitRepositoryHelper
import com.example.gitlist.util.Resource
import com.example.gitlist.util.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var apiHelper: GitRepositoryHelper

    @Mock
    private lateinit var apiRepositoriesObserver: Observer<Resource<GitRepositories>>

    @Before
    fun setUp() {
    }

    @Test
    fun givenServerResponse200_whenRepoData_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(emptyList<GitRepositories>())
                .`when`(apiHelper)
                .getGitRepository()
            val viewModel = HomeViewModel(apiHelper)
            viewModel.getRepositories().observeForever(apiRepositoriesObserver)
            verify(apiHelper).getGitRepository()
            viewModel.getRepositories().removeObserver(apiRepositoriesObserver)
        }
    }

    @Test
    fun givenServerResponseError_whenRepoData_shouldReturnError() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Error Message For You"
            doThrow(RuntimeException(errorMessage))
                .`when`(apiHelper)
                .getGitRepository()
            val viewModel = HomeViewModel(apiHelper)
            viewModel.getRepositories().observeForever(apiRepositoriesObserver)
            verify(apiHelper).getGitRepository()
            verify(apiRepositoriesObserver).onChanged(
                Resource.error(
                    RuntimeException(errorMessage).toString(),
                    null
                )
            )
            viewModel.getRepositories().removeObserver(apiRepositoriesObserver)
        }
    }

    @After
    fun tearDown() {
    }

}