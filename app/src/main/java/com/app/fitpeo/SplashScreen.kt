package com.app.fitpeo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import com.app.fitpeo.base.BaseActivity
import com.app.fitpeo.databinding.ActivitySplashScreenBinding

import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class SplashScreen : BaseActivity() {

    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val an2: Animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        binding.logo.startAnimation(an2)


        val tim=Timer()
        tim.schedule(object : TimerTask() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            override fun run() {
                startActivity(Intent(this@SplashScreen,MainActivity::class.java))
                finish()
            }
        }, 2000)



    }

}