package com.shajt3ch.todoapp.model.remote

import com.shajt3ch.todoapp.model.remote.request.auth.LoginRequest
import com.shajt3ch.todoapp.model.remote.request.auth.RegisterRequest
import com.shajt3ch.todoapp.model.remote.response.auth.LoginResponse
import com.shajt3ch.todoapp.model.remote.response.auth.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkService {

    @POST(Endpoints.REGISTER)
    suspend fun register(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST(Endpoints.LOGIN)
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>


}