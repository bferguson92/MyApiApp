package com.example.myapiapp.presenter

import android.util.Log
import com.example.myapiapp.factory.GitFactory
import com.example.myapiapp.model.RepositoryResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitPresenter (private val myView: Contract.ViewInterface) :
    Contract.PresenterInterface {
    private val gitFactory = GitFactory()


    override fun getGitRepos() {
        gitFactory.getGitRepos().enqueue(object : Callback<List<RepositoryResult>> {

            override fun onResponse(
                call: Call<List<RepositoryResult>>,
                response: Response<List<RepositoryResult>>
            ) {
               response.body()?.let{myRepos->
                   myView.displayRepos(myRepos)
               }
                Log.d("TAG_DATA", "I have ${response.body()?.size}")
            }

            override fun onFailure(call: Call<List<RepositoryResult>>, t: Throwable) {
                myView.onFetchError()
                Log.d("TAG_DATA", t.toString())
            }

        })
    }
}