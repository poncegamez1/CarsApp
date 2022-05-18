package com.poncegamez.carsappfrag.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.poncegamez.carsappfrag.data.VehiculoRepository
import com.poncegamez.carsappfrag.model.Vehiculo
import com.poncegamez.carsappfrag.model.VehiculoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel: ViewModel() {
    private var vehiculosLoad: MutableLiveData<ArrayList<VehiculoItem>> = MutableLiveData<ArrayList<VehiculoItem>>()
    val onVehiculosLoaded : LiveData<ArrayList<VehiculoItem>> = vehiculosLoad

    private val repository = VehiculoRepository()

    fun getVehiculosFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            vehiculosLoad.postValue(repository.getVehiculo())
        }
    }

    fun loadMockVehiculosFromJson(vehiculosString: InputStream?) {
        val vehiculoString = vehiculosString?.bufferedReader().use{it!!.readText()}
        val gson = Gson()
        vehiculosLoad.value = gson.fromJson(vehiculoString, Vehiculo::class.java)
    }
}