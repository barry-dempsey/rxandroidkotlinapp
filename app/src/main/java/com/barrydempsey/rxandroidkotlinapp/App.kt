package com.barrydempsey.rxandroidkotlinapp

import android.app.Application

class App: Application() {

  val component: AppComponent by lazy {
    DaggerAppComponent
        .builder()
        .networkModule(NetworkModule)
        .appModule(AppModule(this))
        .build()
  }

  override fun onCreate() {
    super.onCreate()
    component.inject(this)
  }
}