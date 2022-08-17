package com.dev.pvaeps.ui.fragment.login

data class LoginResponse(
    val success: Boolean,
    val token: String,
    val userType: String
)