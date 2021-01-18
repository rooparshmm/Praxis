package com.mutualmobile.praxis.data.sources.launchList

import com.apollographql.apollo.ApolloClient
import com.mutualmobile.praxis.LaunchListQuery
import com.mutualmobile.praxis.LaunchListQuery.Data
import com.mutualmobile.praxis.data.SafeResult
import com.mutualmobile.praxis.data.remote.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class LaunchListRemoteSource(
  private val apolloClient: ApolloClient,
  private val launchListQuery: LaunchListQuery,
  private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ILaunchListRemoteSource {

  override suspend fun queryLaunchList(): SafeResult<Data> {
    return safeApiCall(
        dispatcher, apolloClient.query(launchListQuery)
    )
  }
}