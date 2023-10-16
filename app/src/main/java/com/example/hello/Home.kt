package com.example.hello

import android.content.Intent
import android.hardware.ConsumerIrManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.stop));

        val cardView: CardView = findViewById(R.id.irtest)
        cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.card))
        val irManager = getSystemService(CONSUMER_IR_SERVICE) as? ConsumerIrManager
        if (irManager != null && irManager.hasIrEmitter()) {
            cardView.setOnClickListener {
                val intent = Intent(this, Sony::class.java)
                startActivity(intent)
            }

        } else {
            cardView.setOnClickListener {
                val intent = Intent(this, Help::class.java)
                startActivity(intent)
            }
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.bottom_home
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.bottom_home -> true
                R.id.bottom_services -> {
                    startActivity(Intent(applicationContext, Settings::class.java))
                    overridePendingTransition(R.anim.left, R.anim.side)
                    finish()
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

}