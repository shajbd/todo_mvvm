package com.shajt3ch.todoapp.model.repository

import com.shajt3ch.todoapp.model.remote.NetworkService
import com.shajt3ch.todoapp.model.remote.request.auth.LoginRequest

/**
 * Created by Shakil Ahmed Shaj on 25,March,2020 .
 * Decima Lab
 * shakilahmedshaj@gmail.com
 */
class LoginRepository(private val networkService: NetworkService) {

    suspend fun login(loginRequest: LoginRequest) = networkService.login(loginRequest)

}