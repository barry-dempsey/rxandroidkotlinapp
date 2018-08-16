package com.barrydempsey.rxandroidkotlinapp

import com.barrydempsey.rxandroidkotlinapp.dao.api.FlightAPI
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

  @Provides
  @Reusable
  @JvmStatic
  internal fun providePostAPI(retrofit: Retrofit) =
      retrofit.create(FlightAPI::class.java)

  @Provides
  @Reusable
  @JvmStatic
  internal fun provideRetrofitInterface() : Retrofit =
      Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create(Gson()))
          .build()

}