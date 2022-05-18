package com.poncegamez.carsappfrag.data

class VehiculoRepository {
    suspend fun getVehiculo() = ApiFactory.retrofit.getVehiculos()
}