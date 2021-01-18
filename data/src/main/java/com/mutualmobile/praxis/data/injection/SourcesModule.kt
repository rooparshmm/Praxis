package com.mutualmobile.praxis.data.injection

import com.apollographql.apollo.ApolloClient
import com.mutualmobile.praxis.LaunchListQuery
import com.mutualmobile.praxis.data.sources.launchList.ILaunchListRemoteSource
import com.mutualmobile.praxis.data.sources.launchList.LaunchListRemoteSource
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
  fun provideLaunchListQuery() = LaunchListQuery()

  @Provides
  @Singleton
  @JvmStatic
  fun provideLaunchListSource(
    apolloClient: ApolloClient,
    apoListQuery: LaunchListQuery
  ): ILaunchListRemoteSource {
    return LaunchListRemoteSource(
        apolloClient, apoListQuery
    )
  }

}