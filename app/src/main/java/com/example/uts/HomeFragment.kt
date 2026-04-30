package com.example.uts

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvWelcome = view.findViewById<TextView>(R.id.tvWelcomeHome)
        val btnGoToForm = view.findViewById<MaterialButton>(R.id.btnGoToForm)
        val btnHeaderLogout = view.findViewById<MaterialCardView>(R.id.btnHeaderLogout)

        val username = AppSession.currentUsername.ifBlank { getString(R.string.guest_user) }
        tvWelcome.text = getString(R.string.welcome_home, username)

        btnGoToForm.setOnClickListener {
            (activity as? DashboardActivity)?.navigateToForm()
        }

        btnHeaderLogout.setOnClickListener {
            (activity as? DashboardActivity)?.logout()
        }
    }
}
