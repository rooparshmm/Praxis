package com.mutualmobile.praxis.ui.home.about

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mutualmobile.praxis.R
import com.mutualmobile.praxis.databinding.FragmentAboutBinding
import com.mutualmobile.praxis.injection.module.SampleClass
import com.mutualmobile.praxis.ui.base.BaseDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AboutDialogFragment : BaseDialogFragment<FragmentAboutBinding, AboutViewModel>() {

  @Inject lateinit var sampleClass: SampleClass

  companion object {
    fun newInstance(): AboutDialogFragment {
      val fragment = AboutDialogFragment()
      val args = Bundle()
      fragment.arguments = args
      return fragment
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    super.onCreateView(inflater, container, savedInstanceState)
    binding.mutualMobileWebLink.movementMethod = LinkMovementMethod.getInstance()
    //sampleClass.testMethod()
    return binding.root
  }

  override fun getViewModelClass(): Class<AboutViewModel> = AboutViewModel::class.java

  override fun layoutId(): Int = R.layout.fragment_about

}