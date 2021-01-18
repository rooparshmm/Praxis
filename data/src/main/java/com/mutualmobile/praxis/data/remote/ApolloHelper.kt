package com.mutualmobile.praxis.data.remote

import com.apollographql.apollo.ApolloClient
import com.mutualmobile.praxis.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object ApolloHelper {

  private val okHttpLoggingInterceptor by lazy {
    HttpLoggingInterceptor().apply {
      level =
        if (BuildConfig.DEBUG)
          HttpLoggingInterceptor.Level.BODY
        else
          HttpLoggingInterceptor.Level.NONE
    }
  }

  fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(okHttpLoggingInterceptor)
        .retryOnConnectionFailure(true)
        .build()
  }

  fun createApolloClient(
    baseUrl: String,
    okHttpClient: OkHttpClient
  ): ApolloClient {
    return ApolloClient.builder()
        .serverUrl(baseUrl)
        .okHttpClient(okHttpClient)
        .build()
  }

}