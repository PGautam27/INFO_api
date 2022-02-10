package com.example.infopack.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.infopack.manager.UserRespository
import com.example.infopack.model.UserResponses
import com.example.infopack.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRespository: UserRespository
): ViewModel() {

    var isLoading = mutableStateOf(false)
    private var _getUserData: MutableLiveData<List<UserResponses>> = MutableLiveData<List<UserResponses>>()
    var getUserData: LiveData<List<UserResponses>> = _getUserData

    suspend fun getUserData(): Resource<List<UserResponses>> {
        val result = userRespository.getUserResponse()
        if (result is Resource.Success) {
            isLoading.value = true
            _getUserData.value = result.data!!
        }

        return result
    }
}