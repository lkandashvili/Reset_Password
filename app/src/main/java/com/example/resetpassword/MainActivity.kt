package com.example.resetpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

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


        resetButton.setOnClickListener() {
            if (isValidPhoneNumber(phone.text.toString())) {
                Toast.makeText(this,"აისაღოლ", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this,"ვერააააააააააააა", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun isValidPhoneNumber(phone: String): Boolean {
        val regex = "^\\d{9}\$".toRegex()
        return phone.matches(regex)
    }

}