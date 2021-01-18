package com.mutualmobile.praxis.data.remote

import com.apollographql.apollo.ApolloQueryCall
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.mutualmobile.praxis.data.SafeResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal suspend fun <T> safeApiCall(
  dispatcher: CoroutineDispatcher,
  apiCall: ApolloQueryCall<T>
): SafeResult<T> {
  return withContext(dispatcher) {
    try {
      val data = apiCall.await()
      SafeResult.Success(data.data!!)
    } catch (throwable: ApolloException) {
      SafeResult.Failure(throwable)
    }
  }
}
