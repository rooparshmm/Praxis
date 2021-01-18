package com.mutualmobile.praxis.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mutualmobile.praxis.data.SafeResult
import com.mutualmobile.praxis.domain.model.toUiModel
import com.mutualmobile.praxis.domain.usecases.QueryLaunchListUseCase
import com.mutualmobile.praxis.ui.base.BaseVM
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class HomeVM @Inject constructor(
  private val queryLaunchListUseCase: QueryLaunchListUseCase
) : BaseVM() {

  private var _viewState: MutableLiveData<HomeViewState> = MutableLiveData()
  val viewState: LiveData<HomeViewState> = _viewState

  fun loadJokes() {
    _viewState.value = HomeViewState.Loading
    viewModelScope.launch {
      when (val result = queryLaunchListUseCase.perform()) {
        is SafeResult.Success -> {
          _viewState.value = HomeViewState.ShowLaunch(
              result.data.launches
                  .launches
                  .mapNotNull { launch -> launch?.toUiModel() })
        }
        is SafeResult.Failure -> {
          Timber.e("onError")
          _viewState.value = HomeViewState.Error(result.message)
        }
      }
    }
  }
}

sealed class HomeViewState {
  object Loading : HomeViewState()
  class ShowLaunch(val data: List<com.mutualmobile.praxis.domain.model.Launch>) : HomeViewState()
  class Error(val message: String) : HomeViewState()
}