package com.mutualmobile.praxis.ui.joke

import androidx.lifecycle.MutableLiveData
import com.mutualmobile.praxis.domain.model.Launch
import com.mutualmobile.praxis.ui.base.BaseViewModel
import javax.inject.Inject

class ShowJokeViewModel @Inject constructor() : BaseViewModel() {

  val jokeStringLiveData = MutableLiveData<String>()

  fun showJoke(jokeList: ArrayList<Launch>) {
    var jokeString = ""
    for (joke in jokeList) {
      jokeString = jokeString + "," + joke.site
    }

    jokeStringLiveData.postValue(jokeString)
  }

}