package com.mutualmobile.praxis.data.sources.login

import com.mutualmobile.praxis.LoginMutation.Data
import com.mutualmobile.praxis.data.SafeResult

interface ILoginRemoteSource {
  suspend fun mutateLogin(email: String): SafeResult<Data>
}