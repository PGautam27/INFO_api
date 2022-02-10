package com.example.infopack.manager

import com.example.infopack.apiNetwork.ApiInterface
import com.example.infopack.model.UserResponses
import com.example.infopack.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject


@ActivityScoped
class UserRespository @Inject constructor(
    private val apiInterface: ApiInterface
) {

    suspend fun getUserResponse(): Resource<List<UserResponses>> {
        val response = try {
            apiInterface.getUserData()
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return Resource.Success(response)
    }
}