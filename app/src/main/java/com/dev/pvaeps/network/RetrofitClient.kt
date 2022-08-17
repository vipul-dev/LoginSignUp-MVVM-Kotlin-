package com.dev.pvaeps.network

import android.content.Context
import com.dev.pvaeps.BuildConfig
import com.dev.pvaeps.utils.ConstantUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    fun  buildApi(
        isAuth: Boolean,
        isPayment: Boolean,
        context: Context
    ): RetrofitApis {
        val httpClient = OkHttpClient.Builder().also {
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                it.addInterceptor(logging)
            }
            it.addInterceptor(getHeaderInterceptor(isAuth,isPayment))

        }.build()
        return Retrofit.Builder()
            .baseUrl(ConstantUtils.SERVER_BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApis::class.java)
    }

    private fun getHeaderInterceptor(auth: Boolean, payment: Boolean): Interceptor {
        val interceptor = Interceptor { chain ->
            val request: Request = when {
                auth -> {
                    chain.request().newBuilder()
                        .addHeader(
                            "Authorization",
                            "Bearer " + ""
                        )
                        .build()
                }
                payment -> {
                    chain.request().newBuilder()
                        .addHeader("Authorization", "JRFOQjnaXzZ8dqPjMww6rWcm3dLTOv35SRvniKwG")
                        .build()
                }
                else -> {
                    chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build()
                }
            }
            chain.proceed(request)
        }

        return interceptor
    }


}