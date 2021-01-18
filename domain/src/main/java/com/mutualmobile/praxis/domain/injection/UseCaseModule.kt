package com.mutualmobile.praxis.domain.injection

import com.mutualmobile.praxis.data.repository.LaunchListRepository
import com.mutualmobile.praxis.data.repository.LoginRepository
import com.mutualmobile.praxis.domain.usecases.LoginUseCase
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

  @Provides
  @Singleton
  @JvmStatic
  fun provideMutateLogin(repository: LoginRepository): LoginUseCase {
    return LoginUseCase(repository)
  }

}