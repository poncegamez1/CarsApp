package com.poncegamez.carsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListVehiculosActivity : AppCompatActivity() {

    private lateinit var listaVehiculos: ArrayList<VehiculoItem>
    private lateinit var vehiculosAdapter: VehiculosAdapter
    private lateinit var vehiculosRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_vehiculos)

        vehiculosRecyclerView = findViewById(R.id.vehiculos_recycler_view)

        listaVehiculos = loadMockVehiculosFromJson()
        vehiculosAdapter = VehiculosAdapter(listaVehiculos)

        vehiculosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = vehiculosAdapter
            setHasFixedSize(false)
        }

    }

    private fun loadMockVehiculosFromJson(): ArrayList<VehiculoItem> {
        val vehiculosString: String = applicationContext.assets.open("vehiculos.json").bufferedReader().use{it.readText()}
        val gson = Gson()
        val vehiculosList = gson.fromJson(vehiculosString, Vehiculo::class.java)
        return vehiculosList
    }
}