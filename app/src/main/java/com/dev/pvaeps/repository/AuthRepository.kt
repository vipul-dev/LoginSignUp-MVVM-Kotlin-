package com.dev.pvaeps.repository

import android.content.Context
import com.dev.pvaeps.network.RetrofitClient
import com.dev.pvaeps.base.BaseRepository

class AuthRepository(
    private val context: Context
) : BaseRepository() {

    suspend fun login(email: String, password: String) = safeApiCall {
        RetrofitClient().buildApi(
            isAuth = false,
            isPayment = true,
            context
        ).login(email, password)
    }

    suspend fun signUp(
        firstName: String,
        lastName: String,
        phoneNumber: String,
        email: String,
        password: String
    ) = safeApiCall {
        RetrofitClient().buildApi(
            isAuth = false,
            isPayment = true,
            context
        ).signup(firstName, lastName, phoneNumber, email, password)
    }

}