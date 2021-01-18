package com.mutualmobile.praxis.domain.usecases

import com.mutualmobile.praxis.LaunchListQuery.Data
import com.mutualmobile.praxis.data.SafeResult
import com.mutualmobile.praxis.data.repository.LaunchListRepository

/**
 * Created by Vipul Asri on 13/01/21.
 */

class QueryLaunchListUseCase(private val launchListRepository: LaunchListRepository) :
    BaseUseCase<SafeResult<Data>, Unit> {

  override suspend fun perform(): SafeResult<Data> {
    return launchListRepository.queryLaunchList()
  }

}