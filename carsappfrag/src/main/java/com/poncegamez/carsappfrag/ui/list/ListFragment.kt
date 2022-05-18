package com.poncegamez.carsappfrag.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.poncegamez.carsappfrag.databinding.FragmentListBinding
import com.poncegamez.carsappfrag.model.VehiculoItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var vehiculosAdapter: VehiculosAdapter
    private var listaVehiculos: ArrayList<VehiculoItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //listViewModel.loadMockVehiculosFromJson(context?.assets?.open("vehiculos.json"))

        listViewModel.getVehiculosFromServer()

        listViewModel.onVehiculosLoaded.observe(viewLifecycleOwner, {result ->
            onVehiculosLoadedSubscribe(result)
        })

        vehiculosAdapter = VehiculosAdapter(listaVehiculos, onItemClicked = {onVehiculoClicked(it)})

        listBinding.vehiculosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = vehiculosAdapter
            setHasFixedSize(false)

        }
    }

    private fun onVehiculosLoadedSubscribe(result: ArrayList<VehiculoItem>?) {
        result?.let {listaVehiculos ->
            vehiculosAdapter.appendItems(listaVehiculos)
        }
    }

    private fun onVehiculoClicked(vehiculo: VehiculoItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(vehiculo = vehiculo))
    }
}