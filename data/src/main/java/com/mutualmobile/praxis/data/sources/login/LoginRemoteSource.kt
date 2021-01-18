package com.mutualmobile.praxis.data.sources.login

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.mutualmobile.praxis.LoginMutation
import com.mutualmobile.praxis.LoginMutation.Data
import com.mutualmobile.praxis.data.SafeResult
import com.mutualmobile.praxis.data.remote.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class LoginRemoteSource(
  private val apolloClient: ApolloClient,
  private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ILoginRemoteSource {

  override suspend fun mutateLogin(email: String): SafeResult<Data> {
    return safeApiCall(
        dispatcher, apolloClient.mutate(LoginMutation(Input.fromNullable(email)))
    )
  }
}