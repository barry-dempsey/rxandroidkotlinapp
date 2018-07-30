package com.barrydempsey.rxandroidkotlinapp

import java.io.Serializable

data class Flight(
    val flightNumber: String,
    val airline: String,
    val departureTime: String,
    val arrivalTime: String,
    val price: Double
): Serializable