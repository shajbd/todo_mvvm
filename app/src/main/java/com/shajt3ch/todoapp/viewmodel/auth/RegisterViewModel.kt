package com.shajt3ch.todoapp.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shajt3ch.todoapp.BuildConfig
import com.shajt3ch.todoapp.model.remote.NetworkService
import com.shajt3ch.todoapp.model.remote.Networking
import com.shajt3ch.todoapp.model.remote.request.auth.RegisterRequest
import com.shajt3ch.todoapp.model.repository.RegisterRepository
import kotlinx.coroutines.Dispatchers.IO

/**
 * Created by Shakil Ahmed Shaj on 25,March,2020 .
 * Decima Lab
 * shakilahmedshaj@gmail.com
 */

class RegisterViewModel : ViewModel() {

    companion object {
        const val TAG = "RegisterViewModel"
    }

    private val networkService: NetworkService = Networking.create(BuildConfig.BASE_URL)
    private val registerRepository = RegisterRepository(networkService)

    fun register(registerRequest: RegisterRequest) = liveData(IO) {
        val data = registerRepository.register(registerRequest)
        emit(data)
    }


}