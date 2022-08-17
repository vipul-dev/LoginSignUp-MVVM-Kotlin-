package com.dev.pvaeps.network

import com.dev.pvaeps.ui.fragment.login.LoginResponse
import com.dev.pvaeps.ui.fragment.signup.SignUpResponse
import com.google.gson.JsonObject
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RetrofitApis {


    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("EmailId") email: String,
        @Field("password") password: String
    ): LoginResponse

    @FormUrlEncoded
    @POST("register")
    suspend fun signup(
        @Field("FirstName") firstName: String,
        @Field("LastName") lastName: String,
        @Field("PhoneNo") phoneNumber: String,
        @Field("EmailId") emailId: String,
        @Field("password") Password: String,
    ): SignUpResponse

}