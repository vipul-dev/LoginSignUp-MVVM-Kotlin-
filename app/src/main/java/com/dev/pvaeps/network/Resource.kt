package com.dev.pvaeps.network

import okhttp3.ResponseBody

/*
* Used for wrap tha api responses and handle the Success and Failure properly
* */
sealed class Resource<out T> {

    data class Success<out T>(val value:T):Resource<T>()

    data class Failure(
        val isNetworkError:Boolean,
        val errorCode:Int?,
        val errorBody:String?
    ):Resource<Nothing>()

}