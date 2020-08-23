package com.example.enigma_movie_theater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = (nav_main_host_fragment_container as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottom_navigation, navController)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.item_menu_all_movies -> {
                    navController.navigate(R.id.action_to_fragment_movie_grid)
                    true
                }

                R.id.item_menu_create_movies -> {
                    navController.navigate(R.id.action_to_fragment_movie_add)
                    true
                }

                else -> {
                    false
                }
            }
        }
    }
}