package com.shajt3ch.todoapp.model.repository

import com.shajt3ch.todoapp.model.remote.NetworkService
import com.shajt3ch.todoapp.model.remote.request.auth.RegisterRequest

/**
 * Created by Shakil Ahmed Shaj on 25,March,2020 .
 * Decima Lab
 * shakilahmedshaj@gmail.com
 */

class RegisterRepository(private val networkService: NetworkService) {

    suspend fun register(registerRequest: RegisterRequest) = networkService.register(registerRequest)

}