package com.etherealmobile.androidSharedPreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.i
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    lateinit var prefs: MySharedPref

    override fun onCreate(savedInstanceState: Bundle?) {

        prefs = MySharedPref(this)
        when (prefs.getNightModeState()) {
            true -> setTheme(R.style.DarkTheme)
            false -> setTheme(R.style.AppTheme)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setSupportActionBar(toolbar_settings)
        supportActionBar!!.title = "Settings"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, SettingsFragment())
            .commit()
    }
}
