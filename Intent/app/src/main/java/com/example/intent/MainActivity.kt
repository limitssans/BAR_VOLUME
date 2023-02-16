package com.example.intent

import android.annotation.SuppressLint
import android.app.Person
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intent.MoveForResultActivity.Companion.EXTRA_SELECTED_VALUE
import com.example.intent.MoveForResultActivity.Companion.RESULT_CODE
import com.example.myintentapp.MoveWithObjectActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvresult: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObjectActivity: Button=
            findViewById(R.id.btn_move_activity_with_object)
        btnMoveWithObjectActivity.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveWithResultActivity: Button =
            findViewById(R.id.btn_move_with_result)
        btnMoveWithResultActivity.setOnClickListener(this)

        tvresult = findViewById(R.id.tv_result)


}

	    override fun onClick(v: View) {
            when (v.id) {
                R.id.btn_move_activity -> {
                    val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                    startActivity(moveIntent)

                }
                R.id.btn_move_activity_data -> {
                    val moveWithDataIntent =
                        Intent(this@MainActivity, MoveWithDataActivity::class.java)
                    moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Pram")
                    moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 16)
                    startActivity(moveWithDataIntent)
                }
                R.id.btn_move_activity_with_object ->{
                    val person = Person("Pramoedya Favian Alfarisy", "favalfarisy175@gmail.com", "malang")
                    val  moveWithObjectIntent = Intent(this@MainActivity,
                        MoveWithObjectActivity:: class.java)
                }
                R.id.btn_dial_number -> {
                    val phoneNumber = "081210841382"
                    val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                    startActivity(dialPhoneIntent)
                }
                R.id.btn_move_with_result -> {
                    val moveWithResultIntent =
                        Intent(this@MainActivity, MoveForResultActivity::class.java)
                    getResult.launch(moveWithResultIntent)
                }
            }
        }
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_CODE){
                val value = it.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0)
                tvresult.setText("Hasil $value")


        }
         }
}

