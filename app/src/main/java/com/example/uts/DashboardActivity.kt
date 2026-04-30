package com.example.uts

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dashboardRoot)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        bottomNav = findViewById(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    openFragment(HomeFragment())
                    true
                }

                R.id.menu_form -> {
                    openFragment(SeminarFormFragment())
                    true
                }

                R.id.menu_result -> {
                    openFragment(ResultFragment())
                    true
                }

                else -> false
            }
        }

        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.menu_home
        }
    }

    fun navigateToForm() {
        bottomNav.selectedItemId = R.id.menu_form
    }

    fun navigateToResult() {
        bottomNav.selectedItemId = R.id.menu_result
    }

    fun navigateToHome() {
        bottomNav.selectedItemId = R.id.menu_home
    }

    fun logout() {
        AppSession.currentUsername = ""
        AppSession.latestRegistration = null
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.fragment_fade_in,
                R.anim.fragment_fade_out,
                R.anim.fragment_fade_in,
                R.anim.fragment_fade_out
            )
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}

