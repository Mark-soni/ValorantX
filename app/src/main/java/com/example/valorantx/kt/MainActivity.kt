package com.example.valorantx.kt

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call.Details
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.valorantx.R
import com.example.valorantx.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null;
    private lateinit var mContext: Context
    private var position: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //splash
        val screenSplash = installSplashScreen()

        // Inicio Bottom Navigation View
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.hostFragmentManager) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView: BottomNavigationView = findViewById<BottomNavigationView>(R.id.top_menu)
        setupWithNavController(bottomNavigationView, navController)

        //Splash
        screenSplash.setKeepOnScreenCondition {true}
        val intent = Intent(this, RedesActivity::class.java)
        startActivity(intent)
        finish()
    }

    //States
    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.song)
        mediaPlayer?.start()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        if(mediaPlayer != null)
            position = mediaPlayer!!.currentPosition
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}