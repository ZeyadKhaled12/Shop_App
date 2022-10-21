package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration

import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil
            .setContentView<ActivityMainBinding>(this,
                R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolBar))

        val navController = findNavController(R.id.fragmentLogin)
        val config = AppBarConfiguration(setOf(R.id.loginFragment,
            R.id.instructionFragment, R.id.shoeDetailFragment,
            R.id.welcomeFragment, R.id.shoeListFragment))

        findViewById<Toolbar>(R.id.toolBar).setupWithNavController(navController, config)

    }

}
