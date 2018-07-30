package com.barrydempsey.rxandroidkotlinapp.dao.api

import com.barrydempsey.rxandroidkotlinapp.Flight
import io.reactivex.Observable

interface FlightsService {

  fun getListOfFlightsFromServer(): Observable<ArrayList<Flight>>

}