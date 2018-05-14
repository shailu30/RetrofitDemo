package com.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "http://api.themoviedb.org/3/"

    private lateinit var retrofit: Retrofit

    val client: Retrofit
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)

            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
            return retrofit
        }
}