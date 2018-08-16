package com.barrydempsey.rxandroidkotlinapp

import android.content.Context
import android.net.ConnectivityManager

class ConnectivityService(context: Context) {

  private var connectivityManager: ConnectivityManager? = null

  init {
    connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
  }

  fun isConnectedOrConnecting(f: ()-> Unit) {
    val activeNetworkInfo = connectivityManager?.activeNetworkInfo
    if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting) {
      f()
    }
  }

}