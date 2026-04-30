package com.example.uts

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SeminarFormFragment : Fragment(R.layout.fragment_form) {

    private val seminarOptions: List<String>
        get() = resources.getStringArray(R.array.seminar_options).toList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tilName = view.findViewById<TextInputLayout>(R.id.tilName)
        val tilEmail = view.findViewById<TextInputLayout>(R.id.tilEmail)
        val tilPhone = view.findViewById<TextInputLayout>(R.id.tilPhone)
        val tilSeminar = view.findViewById<TextInputLayout>(R.id.tilSeminar)
        
        val etName = view.findViewById<TextInputEditText>(R.id.etName)
        val etEmail = view.findViewById<TextInputEditText>(R.id.etEmail)
        val etPhone = view.findViewById<TextInputEditText>(R.id.etPhone)
        val acSeminar = view.findViewById<AutoCompleteTextView>(R.id.acSeminar)
        
        val rgGender = view.findViewById<RadioGroup>(R.id.rgGender)
        val cbAgreement = view.findViewById<CheckBox>(R.id.cbAgreement)
        val btnSubmit = view.findViewById<View>(R.id.btnSubmitRegistration)

        // Setup Dropdown Adapter
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, seminarOptions)
        acSeminar.setAdapter(adapter)

        etName.doAfterTextChanged {
            tilName.error = if (it.isNullOrBlank()) getString(R.string.error_name_required) else null
        }

        etEmail.doAfterTextChanged {
            val value = it?.toString().orEmpty().trim()
            tilEmail.error = when {
                value.isEmpty() -> getString(R.string.error_email_required)
                !isEmailValid(value) -> getString(R.string.error_email_invalid)
                else -> null
            }
        }

        // Logic "Strict 08 Enforcement"
        etPhone.doAfterTextChanged { s ->
            val current = s?.toString().orEmpty()
            val digits = current.filter { it.isDigit() }
            var normalized = digits

            if (digits.isNotEmpty()) {
                when {
                    digits.startsWith("62") -> {
                        normalized = "08" + digits.substring(2)
                    }
                    digits.startsWith("8") -> {
                        normalized = "08" + digits.substring(1)
                    }
                    digits.startsWith("0") && digits.length >= 2 && digits[1] != '8' -> {
                        normalized = "08" + digits.substring(2)
                    }
                    !digits.startsWith("0") -> {
                        normalized = "08" + digits.substring(1)
                    }
                }
            }

            if (normalized.length > 13) {
                normalized = normalized.substring(0, 13)
            }

            if (current != normalized) {
                etPhone.setText(normalized)
                etPhone.setSelection(normalized.length)
                return@doAfterTextChanged
            }

            val value = normalized.trim()
            tilPhone.error = when {
                value.isEmpty() -> getString(R.string.error_phone_required)
                !isPhoneValid(value) -> getString(R.string.error_phone_invalid)
                else -> null
            }
        }

        btnSubmit.setOnClickListener {
            hideKeyboard()
            val name = etName.text?.toString()?.trim().orEmpty()
            val email = etEmail.text?.toString()?.trim().orEmpty()
            val phone = etPhone.text?.toString()?.trim().orEmpty()
            val selectedGenderId = rgGender.checkedRadioButtonId
            val selectedSeminar = acSeminar.text.toString()

            val isNameValid = name.isNotEmpty().also {
                tilName.error = if (!it) getString(R.string.error_name_required) else null
            }
            val isEmailValid = email.isNotEmpty() && isEmailValid(email)
            tilEmail.error = if (!isEmailValid) {
                if (email.isEmpty()) getString(R.string.error_email_required) else getString(R.string.error_email_invalid)
            } else null

            val isPhoneValid = phone.isNotEmpty() && isPhoneValid(phone)
            tilPhone.error = if (!isPhoneValid) {
                if (phone.isEmpty()) getString(R.string.error_phone_required) else getString(R.string.error_phone_invalid)
            } else null

            val isGenderValid = selectedGenderId != -1
            if (!isGenderValid) Toast.makeText(requireContext(), getString(R.string.error_gender_required), Toast.LENGTH_SHORT).show()

            val isSeminarValid = selectedSeminar.isNotEmpty() && selectedSeminar != seminarOptions[0]
            if (!isSeminarValid) tilSeminar.error = getString(R.string.error_seminar_required) else tilSeminar.error = null

            if (!cbAgreement.isChecked) Toast.makeText(requireContext(), getString(R.string.error_agreement_required), Toast.LENGTH_SHORT).show()

            if (isNameValid && isEmailValid && isPhoneValid && isGenderValid && isSeminarValid && cbAgreement.isChecked) {
                val gender = if (selectedGenderId == R.id.rbMale) getString(R.string.gender_male) else getString(R.string.gender_female)

                MaterialAlertDialogBuilder(requireContext())
                    .setTitle(getString(R.string.confirm_title))
                    .setMessage(getString(R.string.confirm_message))
                    .setPositiveButton(getString(R.string.confirm_yes)) { _, _ ->
                        AppSession.latestRegistration = SeminarRegistration(name, email, phone, gender, selectedSeminar)
                        (activity as? DashboardActivity)?.navigateToResult()
                    }
                    .setNegativeButton(getString(R.string.confirm_no), null)
                    .show()
            }
        }
    }

    private fun hideKeyboard() {
        val view = activity?.currentFocus
        if (view != null) {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun isEmailValid(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isPhoneValid(phone: String) = phone.matches(Regex("^08\\d{8,11}$"))
}
