package com.poncegamez.carsappfrag.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth

    private var userLogged : MutableLiveData<Boolean> = MutableLiveData()
    val onUserLogged : LiveData<Boolean> = userLogged

    fun login(email: String, password: String) {

        auth = Firebase.auth

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    userLogged.value = true
                    Log.d("Login", "signInWithEmail:success")
                } else {
                    userLogged.value = false
                    Log.w("Login", "signInWithEmail:failure", task.exception)

                }
            }
    }

}