package com.barrydempsey.rxandroidkotlinapp.view

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import android.widget.Toast
import com.barrydempsey.rxandroidkotlinapp.base.BaseActivity
import com.barrydempsey.rxandroidkotlinapp.Flight
import com.barrydempsey.rxandroidkotlinapp.presenter.MainContract.View
import com.barrydempsey.rxandroidkotlinapp.presenter.MainPresenter
import com.barrydempsey.rxandroidkotlinapp.R.layout
import kotlinx.android.synthetic.main.activity_main.progress_bar
import kotlinx.android.synthetic.main.activity_main.recycler_view

class MainActivity : BaseActivity<MainPresenter>(), View {

  private lateinit var progressBar: ProgressBar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
    progressBar = progress_bar

    fetchFlights()
  }

  private fun fetchFlights() {
    isConnectedOrConnecting {
      presenter.getListOfFlights()
    }
  }

  private fun updateListView(flightList: List<Flight>) {
    val adapter = FlightListAdapter(flightList)
    recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    recycler_view.adapter = adapter
    adapter.notifyDataSetChanged()
  }

  override fun showProgress() {
    progressBar.visibility = android.view.View.VISIBLE
  }

  override fun hideProgress() {
    progressBar.visibility = android.view.View.INVISIBLE
  }

  override fun showListOfFlights(flightsList: List<Flight>) {
    updateListView(flightsList)
  }

  override fun showError(error: Throwable) {
    Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
  }

  override fun instantiatePresenter(): MainPresenter {
    return MainPresenter.newInstance(this, this)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onViewDestroyed()
  }

}
