package com.mutualmobile.praxis.injection.module

import com.apollographql.apollo.ApolloClient
import com.mutualmobile.praxis.AppConstants
import com.mutualmobile.praxis.data.remote.ApolloHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vipul Asri on 13/01/21.
 */

@Module
object NetworkModule {
  @Provides
  @Singleton
  @JvmStatic
  fun provideApollo(): ApolloClient = ApolloHelper.createApolloClient(AppConstants.GRAPH_QL_URL)

}