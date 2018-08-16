package com.barrydempsey.rxandroidkotlinapp.dao

import com.barrydempsey.rxandroidkotlinapp.model.Flight
import io.reactivex.Observable

interface MainRemoteDao {

  fun retrieveListOfFlights(): Observable<ArrayList<Flight>>

}