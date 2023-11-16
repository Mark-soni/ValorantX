package com.example.valorantx.kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.valorantx.R
import com.example.valorantx.databinding.ActivityRegistrarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class RegistrarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnCrear.setOnClickListener {
            val email = binding.txtCorreo.text.toString()
            val pass = binding.txtCrearContraseA.text.toString()
            val confirmPass = binding.txtConfirmar.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                if (pass == confirmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email , pass).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this, SesionActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "La contraseña no coincide", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "No se permiten campos vacíos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
