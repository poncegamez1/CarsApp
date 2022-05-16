package com.poncegamez.carsappfrag.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.poncegamez.carsappfrag.model.Vehiculo
import com.poncegamez.carsappfrag.model.VehiculoItem
import java.io.InputStream

class ListViewModel: ViewModel() {
    private var vehiculosLoad: MutableLiveData<ArrayList<VehiculoItem>> = MutableLiveData<ArrayList<VehiculoItem>>()
    val onVehiculosLoaded : LiveData<ArrayList<VehiculoItem>> = vehiculosLoad

    fun loadMockVehiculosFromJson(vehiculosString: InputStream?) {
        val vehiculoString = vehiculosString?.bufferedReader().use{it!!.readText()}
        val gson = Gson()
        vehiculosLoad.value = gson.fromJson(vehiculoString, Vehiculo::class.java)
    }
}