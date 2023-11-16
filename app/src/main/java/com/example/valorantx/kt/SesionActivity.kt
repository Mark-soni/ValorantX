package com.example.valorantx.kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.valorantx.R
import com.example.valorantx.databinding.ActivitySesionBinding
import com.google.firebase.auth.FirebaseAuth

class SesionActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySesionBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySesionBinding.inflate(layoutInflater)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnEntrar.setOnClickListener{
            val email = binding.txtEmail.text.toString()
            val pass = binding.txtPass.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email , pass).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "No se permiten campos vacíos", Toast.LENGTH_SHORT).show()
            }
        }

        setContentView(binding.root)
        binding.btnCrearcuenta.setOnClickListener {
            val intent = Intent(this, RegistrarActivity::class.java)
            startActivity(intent)
        }
    }

}