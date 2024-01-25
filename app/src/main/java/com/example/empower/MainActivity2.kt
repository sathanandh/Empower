package com.example.empower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btnStart.setOnClickListener {
            val etName = findViewById<EditText>(R.id.etName)
            val etAge = findViewById<EditText>(R.id.etAge)
            val etRegNo = findViewById<EditText>(R.id.etRegNo)

            val name = etName.text.toString()
            val age = etAge.text.toString()
            val regNo = etRegNo.text.toString()

            if (name.isEmpty() || age.isEmpty() || regNo.isEmpty()) {
                showErrorMessage("Please fill in all the fields.")
            } else if (!validateName(name)) {
                showErrorMessage("Please enter a valid name.")
            } else if (!validateAge(age)) {
                showErrorMessage("Please enter a valid age.")
            } else if (!validateRegNo(regNo)) {
                showErrorMessage("Please enter a valid registration number.")
            } else {
                showErrorMessage("Data submission successful.")
            }
        }
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(btnStart, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun validateName(name: String): Boolean {
        val pattern = Pattern.compile("^[a-zA-Z\\s]*$")
        return pattern.matcher(name).matches()
    }

    private fun validateAge(age: String): Boolean {
        return try {
            val number = age.toInt()
            number > 0
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun validateRegNo(regNo: String): Boolean {
        return try {
            val number = regNo.toInt()
            number > 0
        } catch (e: NumberFormatException) {
            false
        }
    }
}


