package com.barrydempsey.rxandroidkotlinapp.dao.api

import android.content.Context
import com.barrydempsey.rxandroidkotlinapp.App
import com.barrydempsey.rxandroidkotlinapp.Flight
import io.reactivex.Observable
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Inject

class AppFlightsService(context: Context): FlightsService {

  @Inject
  lateinit var flightAPI: FlightAPI

  init {
    (context.applicationContext as App).component.inject(this)
  }

  override fun getListOfFlightsFromServer(): Observable<ArrayList<Flight>> {
    return Observable.defer { Observable.fromArray(provideListOfFlights()) }.delay(2, SECONDS)
  }

  private fun provideListOfFlights(): ArrayList<Flight> {
    val flightList: ArrayList<Flight> = arrayListOf()

    //flightAPI.getFlights()//

    for (i in 1 .. 25) {
      val flight = Flight(
          i.toString(),
          String.format("Airline %s", i),
          "21 May 2018",
          "22 May 2018",
          22.33)
      flightList.add(flight)
    }

    return flightList

  }

}