package com.barrydempsey.rxandroidkotlinapp.presenter

import com.barrydempsey.rxandroidkotlinapp.Flight
import io.reactivex.Observable

interface MainContract {

  interface View {

    fun showProgress()

    fun hideProgress()

    fun showListOfFlights(flightsList: List<Flight>)

    fun showError(error: Throwable)

  }

  interface ActionListener {

    fun getListOfFlights()

    fun filterFlightsByNumber(flightNumber: String): Observable<List<Flight>>

    fun onViewDestroyed()

  }

}