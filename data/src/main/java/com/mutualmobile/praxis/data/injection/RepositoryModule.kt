package com.mutualmobile.praxis.data.injection

import com.mutualmobile.praxis.data.repository.LaunchListRepository
import com.mutualmobile.praxis.data.sources.launchList.ILaunchListRemoteSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vipul Asri on 13/01/21.
 */

@Module
object RepositoryModule {

  @Provides
  @Singleton
  @JvmStatic
  fun provideLaunchListRepository(networkSource: ILaunchListRemoteSource): LaunchListRepository {
    return LaunchListRepository(networkSource)
  }

}