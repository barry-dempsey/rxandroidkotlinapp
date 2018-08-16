package com.barrydempsey.rxandroidkotlinapp

import com.barrydempsey.rxandroidkotlinapp.dao.api.AppFlightsService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (NetworkModule::class)])
interface AppComponent {

  fun inject(app: App)

  fun inject(flightsService: AppFlightsService)

  @Component.Builder
  interface Builder {

    fun build() : AppComponent

    fun networkModule(networkModule: NetworkModule): Builder

    fun appModule(appModule: AppModule): Builder

  }

}