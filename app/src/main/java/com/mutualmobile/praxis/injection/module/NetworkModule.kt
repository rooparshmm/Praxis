package com.mutualmobile.praxis.injection.module

import com.mutualmobile.praxis.AppConstants
import com.mutualmobile.praxis.BuildConfig
import com.mutualmobile.praxis.data.services.CoroutineApiService
import com.mutualmobile.praxis.data.services.RxApiService
import com.mutualmobile.praxis.injection.qualifiers.CoroutineRetrofit
import com.mutualmobile.praxis.injection.qualifiers.RxRetrofit
import com.mutualmobile.praxis.repo.JokeRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

  @Provides @Singleton internal fun provideOkHttpClient(): OkHttpClient {
    val httpBuilder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
      val httpLoggingInterceptor = HttpLoggingInterceptor()
      httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
      httpBuilder.interceptors()
          .add(httpLoggingInterceptor)
    }
    return httpBuilder.build()
  }

  @CoroutineRetrofit
  @Provides @Singleton fun provideCoroutineRestAdapter(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
  }

  @RxRetrofit
  @Provides @Singleton fun provideRxRestAdapter(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
  }

  @Provides @Singleton fun provideCoroutineApiService(@CoroutineRetrofit restAdapter: Retrofit): CoroutineApiService {
    return restAdapter.create(CoroutineApiService::class.java)
  }

  @Provides @Singleton fun provideRxApiService(@RxRetrofit restAdapter: Retrofit): RxApiService {
    return restAdapter.create(RxApiService::class.java)
  }

  @Provides @Singleton fun provideCoroutineJokeRepo(coroutineApiService: CoroutineApiService): JokeRepo {
    return JokeRepo(coroutineApiService)
  }

}
