package com.barrydempsey.rxandroidkotlinapp.dao.api

import com.barrydempsey.rxandroidkotlinapp.model.Flight
import io.reactivex.Observable
import retrofit2.http.POST

interface FlightAPI {

  @POST("retrieveFlights/")
  fun getFlights(): Observable<List<Flight>>

}