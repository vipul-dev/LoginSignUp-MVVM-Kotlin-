package com.dev.pvaeps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.dev.pvaeps.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}