package com.mutualmobile.praxis.injection.module

import android.content.Context
import android.widget.Toast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object SampleModule {
  @Provides
  @ActivityScoped
  fun provideSampleClass(@ActivityContext context: Context) = SampleClass(context)
}

class SampleClass(private val context: Context) {
  fun testMethod() {
    Toast.makeText(context, "Test Method", Toast.LENGTH_LONG).show()
  }
}