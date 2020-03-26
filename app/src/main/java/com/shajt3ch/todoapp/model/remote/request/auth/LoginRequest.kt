package com.shajt3ch.todoapp.model.remote.request.auth

import com.google.gson.annotations.SerializedName

/**
 * Created by Shakil Ahmed Shaj on 25,March,2020 .
 * Decima Lab
 * shakilahmedshaj@gmail.com
 */
data class LoginRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
) {
}