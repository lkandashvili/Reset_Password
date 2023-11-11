package com.example.resetpassword

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var phone: EditText
    private lateinit var smsCode: EditText
    private lateinit var resetPassword: EditText
    private lateinit var repeatPassword: EditText
    private lateinit var resetButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        phone = findViewById(R.id.editTextPhone)
        smsCode = findViewById(R.id.editTextNumber)
        resetPassword = findViewById(R.id.editTextTextPassword)
        repeatPassword = findViewById(R.id.editTextTextPassword2)
        resetButton = findViewById(R.id.button)


        resetButton.setOnClickListener {
            if (isValidPhoneNumber(phone.text.toString()) && isValidSMSCode(smsCode.text.toString()) && isValidPassword(resetPassword.text.toString(), repeatPassword.text.toString())) {
                Toast.makeText(this,"ახალ პაროლს მიიღებთ SMS-ით.", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this,"ვერააააააააააააა", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isValidPhoneNumber(phone: String): Boolean {
        val regex = "^\\d{9}\$".toRegex()
        return phone.matches(regex)
    }
    private fun isValidSMSCode(smsCode: String): Boolean {
        val regex = "^\\d{4}\$".toRegex()
        return smsCode.matches(regex)
    }
    private fun isValidPassword(password: String, repeatPassword: String): Boolean {
        val regex = "^(?=.*\\d)[a-zA-Z\\d]{8}\$".toRegex()
        return if (password == repeatPassword) {
            password.matches(regex)
        }else {
            false
        }
    }

}