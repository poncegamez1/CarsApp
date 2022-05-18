package com.poncegamez.carsappfrag.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.poncegamez.carsappfrag.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }*/

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

            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMapsFragment(posicionPunto = vehiculo))
            }
        }
    }


}