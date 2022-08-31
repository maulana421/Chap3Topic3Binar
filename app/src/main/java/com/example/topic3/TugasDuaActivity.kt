package com.example.topic3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class TugasDuaActivity : AppCompatActivity() {

    lateinit var inputNama : EditText
    lateinit var inputNim : EditText
    lateinit var inputUas : EditText
    lateinit var inputUts : EditText
    lateinit var inputTugas : EditText
    lateinit var btnLihat : Button
    lateinit var btnHapus : Button
    lateinit var tvLihat : TextView
    lateinit var tvnamaMahasiswa : TextView
    lateinit var tvNim : TextView
    lateinit var tvUas : TextView
    lateinit var tvUts : TextView
    lateinit var tvTugas : TextView
    lateinit var tvTotal : TextView
    lateinit var tvrataRata : TextView
    lateinit var tvnilaihuruf : TextView
    lateinit var tvStatus : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas_dua)


        id()
        btnLihat.setOnClickListener {
            nilaiMahasiswa()
        }
        btnHapus.setOnClickListener {
            hapus()
        }

    }

    fun id(){
        inputNama = findViewById(R.id.etNama)
        inputNim = findViewById(R.id.etNim)
        inputUas = findViewById(R.id.etUas)
        inputUts = findViewById(R.id.etUts)
        inputTugas = findViewById(R.id.etTugas)
        btnLihat = findViewById(R.id.btnLihat)
        btnHapus = findViewById(R.id.btnDelete)
        tvLihat = findViewById(R.id.tviewResult)
        tvnamaMahasiswa = findViewById(R.id.tviewNama)
        tvNim = findViewById(R.id.tviewNim)
        tvUas = findViewById(R.id.tviewUas)
        tvUts = findViewById(R.id.tviewUts)
        tvTugas = findViewById(R.id.tviewTugas)
        tvTotal = findViewById(R.id.tviewTotal)
        tvrataRata = findViewById(R.id.tviewrataRata)
        tvnilaihuruf = findViewById(R.id.tviewnilaiHuruf)
        tvStatus = findViewById(R.id.tviewStatus)
    }
    private fun hapus(){
        tvLihat.setText("")
        tvnamaMahasiswa.setText("Nama Mahasiswa : ")
        tvNim.setText("Nim : ")
        tvUas.setText("UAS : ")
        tvUts.setText("UTS :")
        tvTugas.setText("Tugas :")
        tvTotal.setText("Total :")
        tvrataRata.setText("Rata-Rata Nilai : ")
        tvnilaihuruf.setText("Nilai Huruf : ")
        tvStatus.setText("Status : ")
    }
    private fun nilaiMahasiswa() {
        val namaMahasiswa = inputNama.text.toString()
        val nim = inputNim.text.toString()
        val nilaiUas = inputUas.text.toString().toInt()
        val nilaiUts = inputUts.text.toString().toInt()
        val nilaiTugas = inputTugas.text.toString().toInt()
        val rataRata = (nilaiUts + nilaiUas + nilaiTugas) / 3
        val hitung = nilaiUts + nilaiUas + nilaiTugas
        var rank = ' '
        var keterangan = ""

        if (namaMahasiswa.isNotBlank() && nim.isNotBlank()){
            when(rataRata){
                in 91..100 -> {
                    rank = 'A'
                    keterangan = "Lulus"
                }
                in 81..90 ->{
                    rank = 'B'
                    keterangan = "Lulus"
                }
                in 71..80 ->{
                    rank = 'C'
                    keterangan = "Lulus"
                }
                in 61..70 ->{
                    rank = 'D'
                    keterangan = "Tidak lulus"
                }
                in 0..60 ->{
                    rank = 'E'
                    keterangan = "Tidak lulus"
                }
            }
            tvnamaMahasiswa.text = "Nama Mahasiswa : $namaMahasiswa"
            tvNim.text = "Nim $nim"
            tvUas.text = "UAS $nilaiUas"
            tvUts.text = "UTS : $nilaiUts"
            tvTugas.text = "TUGAS : $nilaiTugas"
            tvTotal.text = "Total : $hitung"
            tvrataRata.text = "Rata-Rata Nilai : $rataRata"
            tvnilaihuruf.text = "Nilai Huruf : $rank"
            tvStatus.text = "Status : $keterangan"
        }

    }
}
