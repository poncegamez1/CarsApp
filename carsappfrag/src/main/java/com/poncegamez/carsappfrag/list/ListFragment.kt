package com.poncegamez.carsappfrag.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.poncegamez.carsappfrag.databinding.FragmentListBinding
import com.poncegamez.carsappfrag.model.Vehiculo
import com.poncegamez.carsappfrag.model.VehiculoItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var vehiculosAdapter: VehiculosAdapter
    private lateinit var listaVehiculos: ArrayList<VehiculoItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listaVehiculos = loadMockVehiculosFromJson()
        vehiculosAdapter = VehiculosAdapter(listaVehiculos, onItemClicked = {onVehiculoClicked(it)})

        listBinding.vehiculosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = vehiculosAdapter
            setHasFixedSize(false)
        }
    }

    private fun onVehiculoClicked(vehiculo: VehiculoItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(vehiculo = vehiculo))
    }

    private fun loadMockVehiculosFromJson(): ArrayList<VehiculoItem> {
        val vehiculosString: String = context?.assets?.open("vehiculos.json")?.bufferedReader().use{it!!.readText()} // TODO reparar
        val gson = Gson()
        val vehiculosList = gson.fromJson(vehiculosString, Vehiculo::class.java)
        return vehiculosList
    }
}