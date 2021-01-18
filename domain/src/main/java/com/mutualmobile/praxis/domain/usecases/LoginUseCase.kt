package com.mutualmobile.praxis.domain.usecases

import com.mutualmobile.praxis.LoginMutation.Data
import com.mutualmobile.praxis.data.SafeResult
import com.mutualmobile.praxis.data.repository.LoginRepository

/**
 * Created by Vipul Asri on 13/01/21.
 */

class LoginUseCase(private val loginRepository: LoginRepository) :
    BaseUseCase<SafeResult<Data>, String> {

  override suspend fun perform(params: String): SafeResult<Data> {
    return loginRepository.login(params)
  }

}