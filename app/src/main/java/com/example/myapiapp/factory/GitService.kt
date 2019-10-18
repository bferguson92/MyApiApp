package com.example.myapiapp.factory

import com.example.myapiapp.model.RepositoryResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {
    @GET("users/{user_name}/{item_type}")
    fun getMyRepositories(
        @Path("user_name") userName: String,
        @Path("item_type") itemType: String
    ): Call<List<RepositoryResult>>
}