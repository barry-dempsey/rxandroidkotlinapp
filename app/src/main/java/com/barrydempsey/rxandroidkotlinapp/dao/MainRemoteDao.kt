package com.barrydempsey.rxandroidkotlinapp.dao

import com.barrydempsey.rxandroidkotlinapp.Flight
import io.reactivex.Observable

interface MainRemoteDao {

  fun retrieveListOfFlights(): Observable<ArrayList<Flight>>

}