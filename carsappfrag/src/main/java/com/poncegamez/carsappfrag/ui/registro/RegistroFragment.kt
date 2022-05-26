package com.poncegamez.carsappfrag.ui.registro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.poncegamez.carsappfrag.databinding.FragmentRegistroBinding

class RegistroFragment : Fragment() {

    private lateinit var registerviewModel: RegistroViewModel
    private lateinit var registerBinding: FragmentRegistroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerBinding = FragmentRegistroBinding.inflate(inflater, container, false)
        registerviewModel = ViewModelProvider(this)[RegistroViewModel::class.java]

        registerviewModel.onUserCreated.observe(viewLifecycleOwner, { result ->
            onUserCreatedSubscribe(result)
        })

        return registerBinding.root
    }

    private fun onUserCreatedSubscribe(result: Boolean?) {
        result?.let { isRegister ->
            if (isRegister) {
                Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                findNavController().navigate(RegistroFragmentDirections.actionRegistroFragmentToLoginFragment())
            } else
                Toast.makeText(context, "Error en el registro", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(registerBinding){
            crearCuentaButton.setOnClickListener{
                val email = emailEditText.text.toString()
                val nombre = nombreInputText.text.toString()
                val password = passwordEditText.text.toString()

                registerviewModel.register(email, password)
            }
        }
    }
}