package com.poncegamez.carsapp.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.poncegamez.carsapp.databinding.ActivityDetalleBinding
import com.poncegamez.carsapp.model.VehiculoItem
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val vehiculo: VehiculoItem = intent.extras?.getSerializable("vehiculo") as VehiculoItem
        with(detalleBinding){
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