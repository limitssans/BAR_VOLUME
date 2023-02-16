package com.example.ukl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTombolLogin : Button  = findViewById(R.id.btn_tombol_login)


    }

    override fun onClick(v: View){
        when (v.id){
            R.id.btn_tombol_login ->
            {

            }
        }
    }
    }
