package com.example.valorantx.kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.valorantx.R
import com.example.valorantx.databinding.ActivityRedesBinding

class RedesActivity : AppCompatActivity() {

    //Declaración del binding parte 1
    private lateinit var binding: ActivityRedesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redes)

        //Declaración del binding parte 2
        binding = ActivityRedesBinding.inflate(layoutInflater)
        //el setContentView() se le reemplaza el interior del "()" por el binding.root
        setContentView(binding.root)


        binding.btnIniciar.setOnClickListener {
            val intent = Intent(this, SesionActivity::class.java)
            startActivity(intent)
        }

        binding.btnGoogle.setOnClickListener {
            val intent = Intent(this, RegistrarActivity::class.java)
            startActivity(intent)
        }

        binding.btnTwitter.setOnClickListener {
            val intent = Intent(this, RegistrarActivity::class.java)
            startActivity(intent)
        }

    }
}