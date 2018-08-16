package com.barrydempsey.rxandroidkotlinapp.model

import java.io.Serializable

data class Flight(
    val flightNumber: String,
    val airline: String,
    val departureTime: String,
    val arrivalTime: String,
    val price: Double
): Serializable