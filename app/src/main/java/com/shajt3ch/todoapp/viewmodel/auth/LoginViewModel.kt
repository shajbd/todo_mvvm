package com.shajt3ch.todoapp.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shajt3ch.todoapp.BuildConfig
import com.shajt3ch.todoapp.model.remote.NetworkService
import com.shajt3ch.todoapp.model.remote.Networking
import com.shajt3ch.todoapp.model.remote.request.auth.LoginRequest
import com.shajt3ch.todoapp.model.repository.LoginRepository
import kotlinx.coroutines.Dispatchers.IO

/**
 * Created by Shakil Ahmed Shaj on 25,March,2020 .
 * Decima Lab
 * shakilahmedshaj@gmail.com
 */

class LoginViewModel : ViewModel() {

    companion object {
        const val TAG = "LoginViewModel"
    }

    private val networkService: NetworkService = Networking.create(BuildConfig.BASE_URL)
    private val loginRepository = LoginRepository(networkService)

    fun login(loginRequest: LoginRequest) = liveData(IO) {

        val data = loginRepository.login(loginRequest)
        emit(data)
    }


}