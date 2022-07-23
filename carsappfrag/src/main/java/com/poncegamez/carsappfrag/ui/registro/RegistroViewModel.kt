package com.poncegamez.carsappfrag.ui.registro

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.poncegamez.carsappfrag.model.User

class RegistroViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth

    private var userCreated : MutableLiveData<Boolean> = MutableLiveData()
    val onUserCreated : LiveData<Boolean> = userCreated

    fun register(email: String, password: String) {

        auth = Firebase.auth
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    userCreated.value = true
                    Log.d("Registro", "createUserWithEmail:success")
                } else {
                    userCreated.value = false
                    Log.w("Registro", "createUserWithEmail:failure", task.exception)
                }
            }

    }

    fun createUserAccount(email: String, nombre: String) {
        val db = Firebase.firestore
        val user = User(id= "0", email= email, nombre= nombre)
        db.collection("users")
            .add(user)
            .addOnSuccessListener {

            }
            .addOnFailureListener {

            }
    }

}