package com.mutualmobile.praxis.domain.injection

import com.mutualmobile.praxis.data.repository.LaunchListRepository
import com.mutualmobile.praxis.domain.usecases.QueryLaunchListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vipul Asri on 13/01/21.
 */

@Module
object UseCaseModule {

  @Provides
  @Singleton
  @JvmStatic
  fun provideQueryLaunchList(repository: LaunchListRepository): QueryLaunchListUseCase {
    return QueryLaunchListUseCase(repository)
  }

}