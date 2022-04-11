package com.poncegamez.carsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class RegistroVehiculoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_vehiculo)

        var registrarButton: Button = findViewById(R.id.registrar_button)
        var marcaEditText: EditText = findViewById(R.id.marca_edit_text)
        var modeloEditText: EditText = findViewById(R.id.modelo_edit_text)
        var motorEditText: EditText = findViewById(R.id.motor_edit_text)
        val colorVehiculo: Spinner = findViewById(R.id.colores_spinner)

    }
}