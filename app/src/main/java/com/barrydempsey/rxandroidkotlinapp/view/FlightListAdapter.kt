package com.barrydempsey.rxandroidkotlinapp.view

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.barrydempsey.rxandroidkotlinapp.model.Flight
import com.barrydempsey.rxandroidkotlinapp.R.id
import com.barrydempsey.rxandroidkotlinapp.R.layout

class FlightListAdapter(private val flightList: List<Flight>)

  : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(layout.flight_list_view, parent, false)
    return FlightViewHolder(view)
  }

  override fun getItemCount(): Int {
    return flightList.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    (holder as FlightViewHolder).bind(flightList[position])
  }

  inner class FlightViewHolder(view: View?) : ViewHolder(view) {

    private var flightInfoView = view?.findViewById(id.flight_info) as TextView

    fun bind(flight: Flight) {
      flightInfoView.text = String.format("%s : %s, %s -> %s %.2f",
          flight.flightNumber,
          flight.airline,
          flight.departureTime,
          flight.arrivalTime,
          flight.price)
    }

  }

}