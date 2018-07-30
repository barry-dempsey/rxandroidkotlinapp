package com.barrydempsey.rxandroidkotlinapp.dao.api

import com.barrydempsey.rxandroidkotlinapp.Flight
import io.reactivex.Observable

class AppFlightsService: FlightsService {

  override fun getListOfFlightsFromServer(): Observable<ArrayList<Flight>> {
    return Observable.defer { Observable.fromArray(provideListOfFlights()) }
  }

  private fun provideListOfFlights(): ArrayList<Flight> {
    val flightList: ArrayList<Flight> = arrayListOf()

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