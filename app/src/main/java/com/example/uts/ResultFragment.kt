package com.example.uts

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class ResultFragment : Fragment(R.layout.fragment_result) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvStatus = view.findViewById<TextView>(R.id.tvResultStatus)
        val tvSubtitle = view.findViewById<TextView>(R.id.tvResultSubtitle)
        val layoutDetails = view.findViewById<LinearLayout>(R.id.layoutResultDetails)
        val layoutEmpty = view.findViewById<LinearLayout>(R.id.layoutEmptyState)
        val btnBackHome = view.findViewById<MaterialButton>(R.id.btnBackHome)
        val btnGoToForm = view.findViewById<MaterialButton>(R.id.btnGoToFormFromEmpty)

        // Details Row Mapping
        val rowName = view.findViewById<View>(R.id.rowName)
        val rowEmail = view.findViewById<View>(R.id.rowEmail)
        val rowPhone = view.findViewById<View>(R.id.rowPhone)
        val rowGender = view.findViewById<View>(R.id.rowGender)
        val rowSeminar = view.findViewById<View>(R.id.rowSeminar)

        setupRow(rowName, getString(R.string.result_name))
        setupRow(rowEmail, getString(R.string.result_email))
        setupRow(rowPhone, getString(R.string.result_phone))
        setupRow(rowGender, getString(R.string.result_gender))
        setupRow(rowSeminar, getString(R.string.result_seminar))

        val data = AppSession.latestRegistration
        if (data == null) {
            tvStatus.text = getString(R.string.result_empty)
            tvSubtitle.text = getString(R.string.result_empty_desc)
            tvStatus.setTextColor(ContextCompat.getColor(requireContext(), R.color.error))
            layoutDetails.visibility = View.GONE
            layoutEmpty.visibility = View.VISIBLE
        } else {
            tvStatus.text = getString(R.string.registration_success)
            tvSubtitle.text = getString(R.string.result_success_desc)
            tvStatus.setTextColor(ContextCompat.getColor(requireContext(), R.color.success))
            layoutDetails.visibility = View.VISIBLE
            layoutEmpty.visibility = View.GONE

            rowName.findViewById<TextView>(R.id.tvValue).text = data.name
            rowEmail.findViewById<TextView>(R.id.tvValue).text = data.email
            rowPhone.findViewById<TextView>(R.id.tvValue).text = data.phone
            rowGender.findViewById<TextView>(R.id.tvValue).text = data.gender
            rowSeminar.findViewById<TextView>(R.id.tvValue).text = data.seminar
        }

        btnBackHome.setOnClickListener {
            (activity as? DashboardActivity)?.navigateToHome()
        }

        btnGoToForm.setOnClickListener {
            (activity as? DashboardActivity)?.navigateToForm()
        }
    }

    private fun setupRow(view: View, label: String) {
        view.findViewById<TextView>(R.id.tvLabel).text = label
    }
}
