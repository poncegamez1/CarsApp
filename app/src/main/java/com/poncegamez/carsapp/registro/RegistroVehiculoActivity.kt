package com.poncegamez.carsapp.registro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.poncegamez.carsapp.detalle.DetalleActivity
import com.poncegamez.carsapp.R

class RegistroVehiculoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Metodo","onCreate")
        setContentView(R.layout.activity_registro_vehiculo)

        val registrarButton: Button = findViewById(R.id.registrar_button)
        val marcaEditText: EditText = findViewById(R.id.marca_edit_text)
        val modeloEditText: EditText = findViewById(R.id.modelo_edit_text)
        val motorEditText: EditText = findViewById(R.id.motor_edit_text)
        val colorVehiculoSpinner: Spinner = findViewById(R.id.colores_spinner)
        val automaticoRadioButton: RadioButton = findViewById(R.id.automatico_radio_button)
        val mecanicoRadioButton: RadioButton = findViewById(R.id.mecanico_radio_button)
        val gasolinaRadioButton: RadioButton = findViewById(R.id.gasolina_radio_button)
        val dieselRadioButton: RadioButton = findViewById(R.id.diesel_radio_button)
        val electricoRadioButton: RadioButton = findViewById(R.id.electrico_radio_button)
        //val transmisionRadioGroup: RadioGroup = findViewById(R.id.transmision_radio_group)
        //val combustibleRadioGroup: RadioGroup = findViewById(R.id.combustible_radio_group)

        registrarButton.setOnClickListener {
            if (marcaEditText.text.toString() == "")
                marcaEditText.error = "Digite estatura"
            if (modeloEditText.text.toString() == "")
                modeloEditText.error = "Digite modelo"
            if (motorEditText.text.toString() == "")
                motorEditText.error = "Digite motor"
            if (colorVehiculoSpinner.selectedItem.toString() == "--- Seleccione color ---")
                Toast.makeText(this, "Debe seleccionar un color", Toast.LENGTH_SHORT).show()

            if (marcaEditText.text.isEmpty() || modeloEditText.text.isEmpty() || motorEditText.text.isEmpty() || colorVehiculoSpinner.selectedItem.toString() == "--- Seleccione color ---")
                Toast.makeText(this, "Debe diligenciar todos los campos", Toast.LENGTH_LONG).show()
            else{
               val marca: String = marcaEditText.text.toString()
               val modelo: String = modeloEditText.text.toString()
               val motor: String = motorEditText.text.toString()
               val colorVehiculo: String = colorVehiculoSpinner.selectedItem.toString()
               val transmision: String = if (automaticoRadioButton.isChecked) getString(R.string.automatico) else getString(
                   R.string.mecanico
               )
               val combustible = String
                   if (gasolinaRadioButton.isChecked)
                        getString(R.string.gasolina)
                    if (dieselRadioButton.isChecked)
                        getString(R.string.diesel)
                    if (electricoRadioButton.isChecked)
                        getString(R.string.electrico)

                //val vehiculo = Vehiculo(marca, modelo, motor, colorVehiculo, transmision, combustible, urlPic)

               val intent = Intent(this, DetalleActivity::class.java)
               startActivity(intent)
            }

        }


    }

    override fun onStart() {
        super.onStart()
        Log.d("Metodo","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Metodo","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Metodo","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Metodo","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Metodo","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Metodo","onRestart")
    }


}