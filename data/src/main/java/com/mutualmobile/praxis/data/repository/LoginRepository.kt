package com.mutualmobile.praxis.data.repository

import com.mutualmobile.praxis.LoginMutation.Data
import com.mutualmobile.praxis.data.SafeResult
import com.mutualmobile.praxis.data.sources.login.ILoginRemoteSource

class LoginRepository(
  private val remoteSource: ILoginRemoteSource
) {

  suspend fun login(email: String): SafeResult<Data> {
    return remoteSource.mutateLogin(email)
  }

}