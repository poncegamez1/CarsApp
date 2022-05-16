package com.poncegamez.carsappfrag.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.poncegamez.carsappfrag.R
import com.poncegamez.carsappfrag.main.MainActivity

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }*/
}