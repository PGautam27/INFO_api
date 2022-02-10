package com.example.infopack.apiNetwork

import com.example.infopack.model.UserResponses
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ApiInterface {

    @GET("todos")
    suspend fun getUserData(): List<UserResponses>
}