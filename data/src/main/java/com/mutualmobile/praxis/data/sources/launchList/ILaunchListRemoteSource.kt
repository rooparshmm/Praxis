package com.mutualmobile.praxis.data.sources.launchList

import com.mutualmobile.praxis.LaunchListQuery
import com.mutualmobile.praxis.data.SafeResult

interface ILaunchListRemoteSource {
  suspend fun queryLaunchList(): SafeResult<LaunchListQuery.Data>
}