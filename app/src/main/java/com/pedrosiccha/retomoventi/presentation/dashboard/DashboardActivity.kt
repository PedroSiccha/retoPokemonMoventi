package com.pedrosiccha.retomoventi.presentation.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pedrosiccha.retomoventi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        if (savedInstanceState == null) {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            if (navHostFragment == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, DashboardFragment())
                    .commit()
            }
        }

    }
}