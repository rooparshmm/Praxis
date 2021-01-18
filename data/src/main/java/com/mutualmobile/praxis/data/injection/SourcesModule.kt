package com.mutualmobile.praxis.data.injection

import com.apollographql.apollo.ApolloClient
import com.mutualmobile.praxis.data.sources.launchList.ILaunchListRemoteSource
import com.mutualmobile.praxis.data.sources.launchList.LaunchListRemoteSource
import com.mutualmobile.praxis.data.sources.login.ILoginRemoteSource
import com.mutualmobile.praxis.data.sources.login.LoginRemoteSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vipul Asri on 13/01/21.
 */

@Module
object SourcesModule {

  @Provides
  @Singleton
  @JvmStatic
  fun provideLaunchListSource(apolloClient: ApolloClient): ILaunchListRemoteSource {
    return LaunchListRemoteSource(
        apolloClient
    )
  }

  @Provides
  @Singleton
  @JvmStatic
  fun provideLoginSource(apolloClient: ApolloClient): ILoginRemoteSource {
    return LoginRemoteSource(
        apolloClient
    )
  }

}