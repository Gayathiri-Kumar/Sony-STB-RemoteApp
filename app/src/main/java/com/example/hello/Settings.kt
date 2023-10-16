package com.example.hello

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class Settings : AppCompatActivity() {
    lateinit var sound: SwitchCompat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportActionBar?.hide()
        val arrow: Button = findViewById(R.id.arrow)
        arrow.setOnClickListener {
            val intent = Intent(this, Home ::class.java)
            startActivity(intent)
        }

        window.setStatusBarColor(ContextCompat.getColor(this, R.color.stop));
        sound = findViewById(R.id.soundswitch)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.bottom_services
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.bottom_home -> {
                    startActivity(Intent(applicationContext, Home::class.java))
                    overridePendingTransition(R.anim.left, R.anim.side)
                    finish ()
                    true
                }
                R.id.bottom_services -> {
                    true
                }
                R.id.bottom_help -> {
                    startActivity(Intent(applicationContext, Help::class.java))
                    overridePendingTransition(R.anim.left, R.anim.side)
                    finish()
                    true
                }
                else -> false
            }
        }
    }

    fun readSoundSwitchStatus(context: Context): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("soundswitch", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("soundswitch", true)
    }

    private fun updateSoundSwitchStatus() {
        val isSoundEnabled = readSoundSwitchStatus(this)
        sound.isChecked = isSoundEnabled
    }

    fun SoundSwitch(view: View) {
        if (sound.isChecked()) {
            val soundswitchpreferences: SharedPreferences.Editor =
                getSharedPreferences("soundswitch", Context.MODE_PRIVATE).edit()
            soundswitchpreferences.putBoolean("soundswitch", true)
            soundswitchpreferences.apply()
            sound.isChecked = true
        } else {
            val soundpref = getSharedPreferences("soundswitch", Context.MODE_PRIVATE)
            val editor = soundpref.edit()
            editor.putBoolean("soundswitch", false)
            editor.apply()
            sound.isChecked = false
        }
    }

    override fun onResume() {
        super.onResume()

        // Update the state of the sound switch
        updateSoundSwitchStatus()

    }

}
