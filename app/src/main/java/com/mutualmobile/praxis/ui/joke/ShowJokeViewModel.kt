package com.mutualmobile.praxis.ui.joke

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.mutualmobile.praxis.data.model.Joke
import com.mutualmobile.praxis.ui.base.BaseViewModel

class ShowJokeViewModel @ViewModelInject constructor(
  @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

  val jokeStringLiveData = MutableLiveData<String>()

  fun showJoke(jokeList: ArrayList<Joke>) {
    var jokeString = ""
    for (joke in jokeList) {
      jokeString = jokeString + joke.joke.replace("&quot;", "\"") + "\n\n"
    }

    jokeStringLiveData.postValue(jokeString)
  }

}