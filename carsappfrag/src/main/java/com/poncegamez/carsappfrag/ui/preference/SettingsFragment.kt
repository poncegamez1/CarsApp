package com.poncegamez.carsappfrag.ui.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.poncegamez.carsappfrag.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }*/
}