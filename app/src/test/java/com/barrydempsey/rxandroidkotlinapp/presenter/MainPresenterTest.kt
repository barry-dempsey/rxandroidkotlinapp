package com.barrydempsey.rxandroidkotlinapp.presenter

import com.barrydempsey.rxandroidkotlinapp.Flight
import com.barrydempsey.rxandroidkotlinapp.dao.AppMainRemoteDao
import com.barrydempsey.rxandroidkotlinapp.presenter.MainContract.View
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

  private lateinit var presenter: MainPresenter

  private lateinit var testScheduler: TestScheduler

  @Mock private lateinit var remoteDao: AppMainRemoteDao

  @Mock private lateinit var view: View

  @Before
  fun `set up`() {
    MockitoAnnotations.initMocks(this)
    testScheduler = TestScheduler()
    presenter = MainPresenter(remoteDao, view, testScheduler, testScheduler)
  }

  @Test
  fun `get list of flights from server`() {
    doReturn(Observable.just(provideMockListOfFlights())).`when`(remoteDao).retrieveListOfFlights()
    presenter.getListOfFlights()
    testScheduler.triggerActions()
    verify(view).showListOfFlights(provideMockListOfFlights())
  }

  @Test
  fun `test the filter for flight number`() {
    val flightNumberToCheck = "1"
    doReturn(Observable.just(provideMockListOfFlights())).`when`(remoteDao).retrieveListOfFlights()
    val flights = presenter.filterFlightsByNumber(flightNumberToCheck)
    assertNotNull(flights)
    assertEquals(flightNumberToCheck, flights.blockingFirst()[0].flightNumber)
  }

  private fun provideMockListOfFlights(): List<Flight> {
    return arrayListOf<Flight>().apply {
      this.add(Flight("1",
                      "Aer Lingus",
                      "18 May 2018",
                      "19 May 2018",
                      123.45))
    }
  }
}