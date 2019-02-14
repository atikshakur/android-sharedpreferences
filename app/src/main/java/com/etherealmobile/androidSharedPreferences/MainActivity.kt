package com.etherealmobile.androidSharedPreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val NAME_KEY = "name"
        const val GENDER_KEY = "gender"
    }
    lateinit var prefs: MySharedPref

    override fun onCreate(savedInstanceState: Bundle?) {

        prefs = MySharedPref(this)
        when(prefs.getNightModeState()) {
            true -> setTheme(R.style.DarkTheme)
            false -> setTheme(R.style.AppTheme)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        readPrefs()
    }

    private fun readPrefs() {
    val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        name.text = prefs.getString(NAME_KEY, "Name")
        gender.text = prefs.getString(GENDER_KEY, "Male")

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        readPrefs()
    }
}
