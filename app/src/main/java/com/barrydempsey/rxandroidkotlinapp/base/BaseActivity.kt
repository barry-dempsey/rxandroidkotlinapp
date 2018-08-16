package com.barrydempsey.rxandroidkotlinapp.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<P: BasePresenter>: AppCompatActivity() {

  protected lateinit var presenter: P

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter = instantiatePresenter()
  }

  fun isConnectedOrConnecting(f: ()-> Unit) {
    val activeNetworkInfo = connectivityManager().activeNetworkInfo
    if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting) {
      f()
    }
  }

  abstract fun instantiatePresenter(): P

  private fun connectivityManager() = getSystemService(
      Context.CONNECTIVITY_SERVICE) as ConnectivityManager


}