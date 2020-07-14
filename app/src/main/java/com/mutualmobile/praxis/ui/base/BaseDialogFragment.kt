package com.mutualmobile.praxis.ui.base

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mutualmobile.praxis.BR
import com.mutualmobile.praxis.R

abstract class BaseDialogFragment<B : ViewDataBinding, VM : ViewModel> : DialogFragment() {
  protected lateinit var binding: B
  lateinit var viewModel: VM

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
    return binding.root
  }

  private fun bindContentView(layoutId: Int) {
    binding = DataBindingUtil.setContentView(requireActivity(), layoutId)
    viewModel = ViewModelProvider(this).get(getViewModelClass())
    binding.setVariable(BR.viewModel, viewModel)
  }

  abstract fun getViewModelClass(): Class<VM>

  @LayoutRes protected abstract fun layoutId(): Int

}