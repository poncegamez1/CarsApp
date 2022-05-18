package com.poncegamez.carsappfrag.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.poncegamez.carsappfrag.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()

        return when (item.itemId){
            android.R.id.home ->{
                onBackPressed()
                true
            }
            else -> {return true}
        }

    }

    fun showIcon(){
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun hideIcon(){
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
    } VER CLASE 14 NUEVAMENTE*/
}