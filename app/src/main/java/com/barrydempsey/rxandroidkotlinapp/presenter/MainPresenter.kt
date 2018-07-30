package com.barrydempsey.rxandroidkotlinapp.presenter

import com.barrydempsey.rxandroidkotlinapp.dao.AppMainRemoteDao
import com.barrydempsey.rxandroidkotlinapp.Flight
import com.barrydempsey.rxandroidkotlinapp.dao.MainRemoteDao
import com.barrydempsey.rxandroidkotlinapp.presenter.MainContract.ActionListener
import com.barrydempsey.rxandroidkotlinapp.presenter.MainContract.View
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(private val remoteDao: MainRemoteDao,
                    private val view: View,
                    private val processSchedulers: Scheduler,
                    private val androidSchedulers: Scheduler)
  : ActionListener {

  override fun getListOfFlights(numberOfResults: Int) {
    remoteDao.retrieveListOfFlights()
        .subscribeOn(processSchedulers)
        .observeOn(androidSchedulers)
        .doOnNext(this::validateThis)
        .subscribe(
            { flights -> view.showListOfFlights(flights) },
            { error -> view.showError(error) }
        )
  }

  private fun validateThis(flights: ArrayList<Flight>?) {
    flights?.isEmpty() ?: view.showProgress()
  }

  override fun filterFlightsByNumber(flightNumber: String): Observable<List<Flight>> {
    return remoteDao.retrieveListOfFlights()
        .map{ it -> it.filter { it.flightNumber.equals(flightNumber, true) } }
  }

  companion object {

    @JvmStatic
    fun newInstance(view: MainContract.View): MainPresenter =
        MainPresenter(AppMainRemoteDao.newInstance(),
                      view,
                      Schedulers.io(),
                      AndroidSchedulers.mainThread())

  }

}