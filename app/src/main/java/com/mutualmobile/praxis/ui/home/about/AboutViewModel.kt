package com.mutualmobile.praxis.ui.home.about

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.mutualmobile.praxis.ui.base.BaseViewModel

class AboutViewModel @ViewModelInject constructor(
  @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel()