package com.poncegamez.carsappfrag.data

import com.poncegamez.carsappfrag.model.Vehiculo
import retrofit2.http.GET

interface ApiService {
    @GET("poncegamez1/CarsApp/vehiculos")
    suspend fun getVehiculos(): Vehiculo
}