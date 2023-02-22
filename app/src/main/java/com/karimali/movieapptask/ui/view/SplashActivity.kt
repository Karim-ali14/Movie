package com.karimali.movieapptask.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.karimali.movieapptask.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var downTimer:CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        countTimer()
        // Todo animation
    }


    private fun countTimer(){

        downTimer = object : CountDownTimer(3000, 1000) {

            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                startActivity(MoveActivity.getInstance(this@SplashActivity))
                finish()
            }
        }

        downTimer.start()
    }

    override fun onStop() {
        super.onStop()
        downTimer.cancel()
    }
}