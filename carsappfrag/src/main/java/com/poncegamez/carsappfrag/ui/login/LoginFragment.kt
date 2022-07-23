package com.poncegamez.carsappfrag.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.poncegamez.carsappfrag.databinding.FragmentLoginBinding
import com.poncegamez.carsappfrag.utils.isEmailValid

class LoginFragment : Fragment() {

    private lateinit var loginviewModel: LoginViewModel
    private lateinit var loginBinding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        loginviewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        loginviewModel.onUserLogged.observe(viewLifecycleOwner, { result ->
            onUserLoggedSubscribe(result)
        })

        return loginBinding.root
    }

    private fun onUserLoggedSubscribe(result: Boolean?) {
        result?.let { isLoggedIn ->
            if (isLoggedIn){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToNavigationList())
            } else
                Toast.makeText(context, "Error en el inicio de sesión", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(loginBinding) {
            loginButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Debe digitar correo electrónico y contraseña",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else
                    if (!isEmailValid(email)) {
                        Toast.makeText(
                            context,
                            "No corresponde a un formato de correo electrónico",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        loginviewModel.login(email, password)
                    }
            }
            registrarseTextView.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegistroFragment())
            }
        }
    }
}