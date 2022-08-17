package com.dev.pvaeps.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.dev.pvaeps.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Handler(Looper.getMainLooper()).postDelayed({
            finish()
            startActivity(Intent(this, AuthActivity::class.java))
        },1500)

    }
}