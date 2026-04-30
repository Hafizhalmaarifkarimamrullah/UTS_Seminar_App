package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private enum class AuthMode { LOGIN, REGISTER }

    private val users = mutableMapOf(
        "mahasiswa" to "12345",
        "admin" to "admin123"
    )

    private lateinit var cardAuth: MaterialCardView
    private lateinit var tvAuthTitle: TextView
    private lateinit var tilUsername: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var tilConfirmPassword: TextInputLayout
    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirmPassword: TextInputEditText
    private lateinit var btnAuthPrimary: MaterialButton
    private lateinit var btnAuthSwitch: MaterialButton

    private var authMode = AuthMode.LOGIN

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bindViews()
        setupListeners()
        renderAuthMode()
        showAuthScreen()
    }

    private fun bindViews() {
        cardAuth = findViewById(R.id.cardAuth)
        tvAuthTitle = findViewById(R.id.tvAuthTitle)
        tilUsername = findViewById(R.id.tilUsername)
        tilPassword = findViewById(R.id.tilPassword)
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnAuthPrimary = findViewById(R.id.btnAuthPrimary)
        btnAuthSwitch = findViewById(R.id.btnAuthSwitch)
    }

    private fun setupListeners() {
        etUsername.doAfterTextChanged { tilUsername.error = null }
        etPassword.doAfterTextChanged { tilPassword.error = null }
        etConfirmPassword.doAfterTextChanged { tilConfirmPassword.error = null }

        btnAuthPrimary.setOnClickListener {
            when (authMode) {
                AuthMode.LOGIN -> handleLogin()
                AuthMode.REGISTER -> handleRegister()
            }
        }

        btnAuthSwitch.setOnClickListener {
            authMode = if (authMode == AuthMode.LOGIN) AuthMode.REGISTER else AuthMode.LOGIN
            renderAuthMode()
        }
    }

    private fun renderAuthMode() {
        val isLogin = authMode == AuthMode.LOGIN
        tvAuthTitle.text = if (isLogin) getString(R.string.login_title) else getString(R.string.register_title)
        tilConfirmPassword.visibility = if (isLogin) android.view.View.GONE else android.view.View.VISIBLE
        btnAuthPrimary.text = if (isLogin) getString(R.string.login_button) else getString(R.string.register_button)
        btnAuthSwitch.text = if (isLogin) getString(R.string.move_to_register) else getString(R.string.move_to_login)
        clearInputErrors()
    }

    private fun handleLogin() {
        val username = etUsername.text?.toString()?.trim().orEmpty()
        val password = etPassword.text?.toString().orEmpty()

        if (username.isEmpty() || password.isEmpty()) {
            if (username.isEmpty()) {
                tilUsername.error = getString(R.string.error_field_required)
            }
            if (password.isEmpty()) {
                tilPassword.error = getString(R.string.error_field_required)
            }
            Toast.makeText(this, getString(R.string.error_empty_login), Toast.LENGTH_SHORT).show()
            return
        }

        val isValid = users[username] == password
        if (!isValid) {
            tilPassword.error = getString(R.string.error_login_invalid)
            Toast.makeText(this, getString(R.string.error_login_invalid), Toast.LENGTH_SHORT).show()
            return
        }

        AppSession.currentUsername = username
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    private fun handleRegister() {
        val username = etUsername.text?.toString()?.trim().orEmpty()
        val password = etPassword.text?.toString().orEmpty()
        val confirmPassword = etConfirmPassword.text?.toString().orEmpty()

        when {
            username.length < 4 -> {
                tilUsername.error = getString(R.string.error_username_short)
                Toast.makeText(this, getString(R.string.error_username_short), Toast.LENGTH_SHORT).show()
            }
            password.length < 4 -> {
                tilPassword.error = getString(R.string.error_password_short)
                Toast.makeText(this, getString(R.string.error_password_short), Toast.LENGTH_SHORT).show()
            }
            password != confirmPassword -> {
                tilConfirmPassword.error = getString(R.string.error_password_not_match)
                Toast.makeText(this, getString(R.string.error_password_not_match), Toast.LENGTH_SHORT).show()
            }
            users.containsKey(username) -> {
                tilUsername.error = getString(R.string.error_user_exists)
                Toast.makeText(this, getString(R.string.error_user_exists), Toast.LENGTH_SHORT).show()
            }
            else -> {
                users[username] = password
                Toast.makeText(this, getString(R.string.register_success), Toast.LENGTH_SHORT).show()
                authMode = AuthMode.LOGIN
                etPassword.setText("")
                etConfirmPassword.setText("")
                renderAuthMode()
            }
        }
    }

    private fun showAuthScreen() {
        cardAuth.visibility = android.view.View.VISIBLE
    }

    private fun clearInputErrors() {
        tilUsername.error = null
        tilPassword.error = null
        tilConfirmPassword.error = null
    }
}