package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class Help : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        supportActionBar?.hide()
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.stop));
        val imageList = ArrayList<SlideModel>()
        val arrow: Button = findViewById(R.id.arrowh)
        arrow.setOnClickListener {
            val intent = Intent(this, Home ::class.java)
            startActivity(intent)
        }
        imageList.add(SlideModel(R.drawable.ir1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ir2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ir3, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ir4, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ir5, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ir6, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ir7, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ir8, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ir9, ScaleTypes.FIT))

        val imageSlider = findViewById<ImageSlider>(R.id.imageslider)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.bottom_help
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.bottom_home -> {
                    startActivity(Intent(applicationContext, Home::class.java))
                    overridePendingTransition(R.anim.left, R.anim.side)
                    finish ()
                    true
                }
                R.id.bottom_services -> {
                    startActivity(Intent(applicationContext, Settings::class.java))
                    overridePendingTransition(R.anim.left, R.anim.side)
                    finish()
                    true
                }
                R.id.bottom_help -> {
                    true
                }
                else -> false
            }
        }
    }
}