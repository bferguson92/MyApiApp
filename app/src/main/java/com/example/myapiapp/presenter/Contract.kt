package com.example.myapiapp.presenter

import com.example.myapiapp.model.RepositoryResult

interface Contract{

    interface PresenterInterface{
        fun getGitRepos()
    }

    interface ViewInterface {
        fun displayRepos(repos: List<RepositoryResult>)
        fun onFetchError()
    }
}