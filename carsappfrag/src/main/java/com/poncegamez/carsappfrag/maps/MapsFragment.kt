package com.poncegamez.carsappfrag.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.poncegamez.carsappfrag.R

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->

        val args: MapsFragmentArgs by navArgs()
        val punto = args.posicionPunto

        val puntoMapa = LatLng(punto.latitud.toString().toDouble(),punto.longitud.toString().toDouble())
        googleMap.addMarker(MarkerOptions().position(puntoMapa).title(punto.marca))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(puntoMapa,8F))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}