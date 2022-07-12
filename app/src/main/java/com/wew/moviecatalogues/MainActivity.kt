package com.wew.moviecatalogues

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomView)
        val navController = findNavController(R.id.nav_host)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.movieFragment2, R.id.tvShowFragment2, R.id.favoriteFragment2))
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)

    }
}
