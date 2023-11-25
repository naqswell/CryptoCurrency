package com.example.network_coinstats

import okhttp3.Interceptor
import okhttp3.Response


class CoinStatsApiKeyInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("X-API-KEY", apiKey)
        return chain.proceed(request.build())
    }
}