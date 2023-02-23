package com.example.zsecurity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_nav_bar)

        bottomBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> {
                    inflateFragment(ProfileFragment.newInstance())
                }
                R.id.Shield -> {
                    inflateFragment(GuardFragment.newInstance())
                }
                R.id.dash_board -> {
                    inflateFragment(DashboardFragment.newInstance())
                }
                else -> {
                    inflateFragment(HomeFragment.newInstance())
                }
            }

            true
        }

        bottomBar.selectedItemId = R.id.nav_home

    }



    private fun inflateFragment(newInstance: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, newInstance)
        transaction.commit()

    }

}