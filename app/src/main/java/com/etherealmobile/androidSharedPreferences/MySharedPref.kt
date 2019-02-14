package com.etherealmobile.androidSharedPreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class MySharedPref(context: Context) {

    var prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun setNightModeState(state: Boolean) = prefs.edit().putBoolean("NightMode", state).apply()

    fun getNightModeState(): Boolean = prefs.getBoolean("dark_mode", false)
}