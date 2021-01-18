package com.mutualmobile.praxis.data.repository

import com.mutualmobile.praxis.LaunchListQuery
import com.mutualmobile.praxis.data.SafeResult
import com.mutualmobile.praxis.data.sources.launchList.ILaunchListRemoteSource

class LaunchListRepository(
  private val remoteSource: ILaunchListRemoteSource
) {

  suspend fun queryLaunchList(): SafeResult<LaunchListQuery.Data> {
    return remoteSource.queryLaunchList()
  }

}