package com.example.intent

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data3)

        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        val tvDataRecevied: TextView = findViewById(R.id.tv_data_received)
        val name = intent.getStringExtra(EXTRA_NAME)
            val age = intent.getIntExtra(EXTRA_AGE, 0)
        val text ="name : $name, Your age : $age"
        tvDataRecevied.text = text

                }

            companion object {
                const val EXTRA_AGE = "extra_age"
                const val EXTRA_NAME = "extra_name"
            }
        }


