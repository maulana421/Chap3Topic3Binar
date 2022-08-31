package com.example.topic3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class TugasActivity : AppCompatActivity() {

    lateinit var inputUmur : EditText
    lateinit var inputTinggi : EditText
    lateinit var inputBerat : EditText
    lateinit var btnResulte : Button
    lateinit var btnReset : Button
    lateinit var btnPindah : Button
    lateinit var tviewHasil : TextView
    lateinit var tviewUmur : TextView
    lateinit var tviewTinggi : TextView
    lateinit var tviewBerat : TextView
    lateinit var tviewBmi : TextView
    lateinit var tviewKategori : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas)



        allId()
        btnResulte.setOnClickListener {
            hitungBmi()
        }
        btnReset.setOnClickListener {
            resetData()
        }
        kenilaiMahasiswa()


    }

    fun allId(){
        inputUmur = findViewById(R.id.etUmur)
        inputTinggi = findViewById(R.id.etTb)
        inputBerat = findViewById(R.id.etBb)
        btnResulte = findViewById(R.id.btnLihat)
        btnReset = findViewById(R.id.btnDelete)
        btnPindah = findViewById(R.id.btnContinue)
        tviewHasil = findViewById(R.id.tviewHasil)
        tviewUmur = findViewById(R.id.tviewUmur)
        tviewTinggi = findViewById(R.id.tviewTb)
        tviewBerat = findViewById(R.id.tviewBb)
        tviewBmi = findViewById(R.id.tviewBmi)
        tviewKategori = findViewById(R.id.tviewKategori)
    }

    fun kenilaiMahasiswa(){
        btnPindah.setOnClickListener {
            startActivity(Intent(this,TugasDuaActivity::class.java))
        }
    }
    private fun resetData(){
        tviewUmur.setText("Umur anda : ")
        tviewTinggi.setText("Tinggi : ")
        tviewBerat.setText("Berat Badan : ")
        tviewBmi.setText("BMI anda")
        tviewKategori.setText("Kategori : ")
    }

    private fun hitungBmi(){
            val inpuUmur= inputUmur.text.toString().toInt()
            val inputTinggi = inputTinggi.text.toString().toDouble() / 100.0
            val inputBerat = inputBerat.text.toString().toInt()
            val hasil = (inputBerat/ (inputTinggi * inputTinggi)).toInt()
            var kategori = ""
            when{
                hasil < 16 -> kategori = "Terlalu kurus"
                hasil in 16..17-> kategori = "Cukup Kurus"
                hasil.toDouble() in 17.0..18.5 -> kategori = "edikit Kurus"
                hasil.toDouble() in 18.6 ..24.9 -> kategori = "Normal"
                hasil in 25..30 -> kategori = "Gemuk"
                hasil in 30..35 -> kategori = "Obesitas Kelas I"
                hasil in 35..40 -> kategori = "Obesitas Kelas II"
                hasil > 40 -> kategori = "Obesitas Kelas III"
            }
        tviewUmur.text = "Umur anda: $inpuUmur"
        tviewTinggi.text = "Tinggi: ${(inputTinggi * 100.0).toInt()}"
        tviewBerat.text = "Berat Badan: $inputBerat"
        tviewBmi.text = "BMI anda: $hasil"
        tviewKategori.text = "Kategori: $kategori"

    }


}