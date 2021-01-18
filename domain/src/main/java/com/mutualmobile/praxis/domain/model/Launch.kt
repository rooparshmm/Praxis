package com.mutualmobile.praxis.domain.model

import android.os.Parcelable
import com.mutualmobile.praxis.LaunchListQuery.Launch
import kotlinx.parcelize.Parcelize

@Parcelize
data class Launch(
  val typeName: String,
  val id: String,
  val site: String?
) : Parcelable

fun Launch.toUiModel() = with(this) {
  Launch(typeName = __typename(), id = id(), site = site())
}