package com.mutualmobile.praxis.injection.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.mutualmobile.praxis.utils.IRxSchedulers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

  @Provides
  @Singleton
  fun provideRxSchedulers(): IRxSchedulers {
    return object : IRxSchedulers {
      override fun main() = AndroidSchedulers.mainThread()
      override fun io() = Schedulers.io()
    }
  }

  @Provides @Singleton
  fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
    return PreferenceManager.getDefaultSharedPreferences(context)
  }
}
