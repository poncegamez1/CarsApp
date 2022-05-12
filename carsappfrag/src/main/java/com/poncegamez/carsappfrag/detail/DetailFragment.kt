package com.poncegamez.carsappfrag.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.poncegamez.carsappfrag.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vehiculo =  args.vehiculo
        with(detailBinding){
            tituloDetalleTextView.text = vehiculo.marca
            marcaDetalleTextView.text = vehiculo.marca
            modeloDetalleTextView.text = vehiculo.modelo
            motorDetalleTextView.text = vehiculo.motor
            colorDetalleTextView.text = vehiculo.color
            transmisionDetalleTextView.text = vehiculo.transmision
            combustibleDetalleTextView.text = vehiculo.combustible
            Picasso.get().load(vehiculo.urlPic).into(imagenDetalleImageView)
        }
    }


}