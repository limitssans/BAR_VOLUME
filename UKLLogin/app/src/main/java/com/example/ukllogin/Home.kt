package com.example.ukllogin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.TextView

class Home : AppCompatActivity() {

    private lateinit var username: TextView
    private lateinit var tampilEmail: TextView
    private var email: String? = null

    private val key_Email = "MM"

    @SuppressLint("MissingInflatedid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tampilEmail = findViewById(R.id.tampilEmail)

        val extras = intent.extras
        email = extras?.getString(key_Email)
        tampilEmail.text = "Email = $email"

    }
}