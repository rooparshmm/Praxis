package com.mutualmobile.praxis.ui.home

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.mutualmobile.praxis.R
import com.mutualmobile.praxis.databinding.ActivityHomeBinding
import com.mutualmobile.praxis.domain.model.Launch
import com.mutualmobile.praxis.ui.base.ActivityNavigator
import com.mutualmobile.praxis.ui.base.BaseActivity
import com.mutualmobile.praxis.ui.home.HomeViewState.Error
import com.mutualmobile.praxis.ui.home.HomeViewState.Loading
import com.mutualmobile.praxis.ui.home.HomeViewState.ShowLaunch
import com.mutualmobile.praxis.ui.home.about.AboutFragment
import com.mutualmobile.praxis.ui.joke.ShowJokeActivity

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeVM>() {
  override fun getViewModelClass(): Class<HomeVM> = HomeVM::class.java

  override fun layoutId(): Int = R.layout.activity_home

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    addListeners()
    addObservers()
  }

  private fun addListeners() {
    with(binding) {
      randomJokesButtonCoroutine.setOnClickListener { viewModel.loadJokes() }
      aboutButton.setOnClickListener { showAboutFragment() }
    }
  }

  private fun addObservers() {
    viewModel.viewState.observe(this, Observer { state ->
      when (state) {
        is Loading -> {
          handleDataLoadingUi(true)
        }
        is ShowLaunch -> {
          handleDataLoadingUi(false)
          showJokeActivity(
              state.data as ArrayList<Launch>
          )
        }
        is Error -> {
          handleDataLoadingUi(false)
        }
      }
    })
  }

  private fun showJokeActivity(data: ArrayList<Launch>) {
    val bundle = Bundle().apply {
      putParcelableArrayList(ShowJokeActivity.JOKE_LIST_INTENT, data)
    }

    ActivityNavigator.startActivityWithDataAndAnimation(
        ShowJokeActivity::class.java, bundle, R.anim.slide_left_in, R.anim.slide_left_out, this
    )
  }

  private fun showAboutFragment() {
    val fragment = AboutFragment.newInstance()
    fragment.show(supportFragmentManager, "dialog")
  }

  private fun handleDataLoadingUi(loading: Boolean) {
    with(binding) {
      progressbar.isVisible = loading
      randomJokesButtonCoroutine.isEnabled = !loading
      aboutButton.isEnabled = !loading
    }
  }
}