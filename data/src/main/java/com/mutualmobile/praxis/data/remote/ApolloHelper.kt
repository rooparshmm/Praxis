package com.mutualmobile.praxis.data.remote

import com.apollographql.apollo.ApolloClient

object ApolloHelper {
  fun createApolloClient(
    baseUrl: String
  ): ApolloClient {
    return ApolloClient.builder()
        .serverUrl(baseUrl)
        .build()
  }

}