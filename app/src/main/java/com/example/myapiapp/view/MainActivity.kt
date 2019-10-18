package com.example.myapiapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapiapp.R
import com.example.myapiapp.presenter.Contract
import com.example.myapiapp.presenter.GitPresenter
import com.example.myapiapp.model.RepositoryResult
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), Contract.ViewInterface {
    lateinit var myPresenter: Contract.PresenterInterface

    override fun onFetchError() {
        Toast.makeText(this, "FAILED", Toast.LENGTH_SHORT).show()
    }

    override fun displayRepos(repos: List<RepositoryResult>) {
        val stringBuilder = StringBuilder()
        repos.forEach{ repo->
            stringBuilder.append("${repo.name}\n")
        }

        text_view_results.text = stringBuilder.toString()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myPresenter = GitPresenter(this)



        button_get_repos.setOnClickListener{
            myPresenter.getGitRepos()
        }
    }
}
