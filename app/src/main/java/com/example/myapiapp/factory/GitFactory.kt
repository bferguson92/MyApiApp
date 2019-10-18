package com.example.myapiapp.factory

import com.example.myapiapp.model.RepositoryResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitFactory {
    val BASE_URL = "https://api.github.com/"

    private lateinit var gitService: GitService

    init {
        gitService = createGitService(getRetrofitInstance())
    }

    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createGitService(retrofit: Retrofit): GitService{
        return retrofit.create(GitService::class.java)
    }

    fun getGitRepos(): Call<List<RepositoryResult>>{
        return gitService.getMyRepositories("bferguson92", "repos")
    }
}