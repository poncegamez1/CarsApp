package com.poncegamez.carsapp.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.poncegamez.carsapp.R
import com.poncegamez.carsapp.detalle.DetalleActivity
import com.poncegamez.carsapp.model.Vehiculo
import com.poncegamez.carsapp.model.VehiculoItem

class ListVehiculosActivity : AppCompatActivity() {

    private lateinit var listaVehiculos: ArrayList<VehiculoItem>
    private lateinit var vehiculosAdapter: VehiculosAdapter
    private lateinit var vehiculosRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_vehiculos)

        vehiculosRecyclerView = findViewById(R.id.vehiculos_recycler_view)

        listaVehiculos = loadMockVehiculosFromJson()
        vehiculosAdapter = VehiculosAdapter(listaVehiculos, onItemClicked = {onVehiculoClicked(it)})

        vehiculosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = vehiculosAdapter
            setHasFixedSize(false)
        }

    }

    private fun onVehiculoClicked(vehiculo: VehiculoItem) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("vehiculo", vehiculo)
        startActivity(intent)
    }

    private fun loadMockVehiculosFromJson(): ArrayList<VehiculoItem> {
        val vehiculosString: String = applicationContext.assets.open("vehiculos.json").bufferedReader().use{it.readText()}
        val gson = Gson()
        val vehiculosList = gson.fromJson(vehiculosString, Vehiculo::class.java)
        return vehiculosList
    }
}