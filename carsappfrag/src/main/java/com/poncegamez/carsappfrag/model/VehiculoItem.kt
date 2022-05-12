package com.poncegamez.carsappfrag.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VehiculoItem(
    @SerializedName("color")
    val color: String?,
    @SerializedName("combustible")
    val combustible: String?,
    @SerializedName("marca")
    val marca: String?,
    @SerializedName("modelo")
    val modelo: String?,
    @SerializedName("motor")
    val motor: String?,
    @SerializedName("transmision")
    val transmision: String?,
    @SerializedName("urlPic")
    val urlPic: String?
) : Serializable