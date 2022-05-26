package com.poncegamez.carsappfrag.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.poncegamez.carsappfrag.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var splashBinding: FragmentSplashBinding
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        splashBinding = FragmentSplashBinding.inflate(inflater, container, false)

        splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]

        splashViewModel.onUserLoggedIn.observe(viewLifecycleOwner, {result ->
            onUserLoggedInSubscribe(result)
        })

        return  splashBinding.root
    }

    private fun onUserLoggedInSubscribe(result: Boolean?) {
        result?.let{ isUserLoggedIn ->
            if(isUserLoggedIn)
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToNavigationList())
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Thread.sleep(2000)
        checkUserConnected()

    }

    private fun checkUserConnected() {
        splashViewModel.checkUserConnected()
    }

}