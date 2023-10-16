package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.Wave

class Splash : AppCompatActivity() {
    var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val progressBar = findViewById<View>(R.id.spin_kit) as ProgressBar
        val wave: Sprite = Wave()
        supportActionBar?.hide()
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.stop));
        image = findViewById(R.id.splash)
        Handler().postDelayed({
            val intent = Intent(this@Splash, Home ::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN.toLong())

    }
    companion object {
        private const val SPLASH_SCREEN = 3500
    }
}