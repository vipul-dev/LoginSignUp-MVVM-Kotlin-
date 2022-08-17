package com.dev.pvaeps.responses

data class LoginResponse(
    val success: Boolean,
    val token: String,
    val userType: String
)