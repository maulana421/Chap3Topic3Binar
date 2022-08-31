package com.example.topic3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnLoginn : Button
    lateinit var viewSay : TextView
    lateinit var btnSignup : Button
    lateinit var ettxtSatu: EditText
    lateinit var edttxtDua : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLoginn = findViewById(R.id.btnLogin)
        viewSay = findViewById(R.id.tvHasil)
        btnSignup = findViewById(R.id.btnSign)
        ettxtSatu= findViewById(R.id.etnumberSatu)
        edttxtDua = findViewById(R.id.etnumberDua)
        save()
        btnSignup.setOnClickListener {
            viewSay.text = "Silahkan Sign up"
        }
        pindah()
    }
    fun save(){
        btnLoginn.setOnClickListener {
            val numberOne = ettxtSatu.text.toString().toInt()
            val numberTwo = edttxtDua.text.toString().toInt()
            val hasil = numberOne + numberTwo
            viewSay.text = hasil.toString()
        }
    }

    fun pindah(){
        btnSignup.setOnClickListener {
            startActivity(Intent(this,TugasActivity::class.java))
        }
    }

}