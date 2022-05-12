package com.poncegamez.carsappfrag.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.poncegamez.carsappfrag.R
import com.poncegamez.carsappfrag.model.VehiculoItem
import com.squareup.picasso.Picasso

class VehiculosAdapter(
    private val vehiculosList: ArrayList<VehiculoItem>,
    private val onItemClicked: (VehiculoItem) -> Unit)
    : RecyclerView.Adapter<VehiculosAdapter.VehiculoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiculoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_vehiculo_item, parent, false)
        return VehiculoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehiculoViewHolder, position: Int) {
        val vehiculo = vehiculosList[position]
        holder.itemView.setOnClickListener { onItemClicked(vehiculosList[position]) }
        holder.bind(vehiculo)
    }

    override fun getItemCount(): Int {
        return vehiculosList.size
    }

    class VehiculoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var nombreTextView: TextView = itemView.findViewById(R.id.nombre_text_view)
        private var modeloTextView: TextView = itemView.findViewById(R.id.modelo_text_view)
        private var fotoImageView: ImageView = itemView.findViewById(R.id.foto_image_view)

        fun bind(vehiculo: VehiculoItem){
            nombreTextView.text = vehiculo.marca
            modeloTextView.text = vehiculo.modelo
            Picasso.get().load(vehiculo.urlPic).resize(200,200).into(fotoImageView)
        }
    }
}