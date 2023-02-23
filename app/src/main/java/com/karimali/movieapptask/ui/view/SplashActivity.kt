package com.karimali.movieapptask.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.karimali.movieapptask.R
import com.karimali.movieapptask.fcm.MyFirebaseMessagingService

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var downTimer:CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        countTimer()
    }

    private fun countTimer() {

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

    override fun onDestroy() {
        super.onDestroy()
        downTimer.cancel()
    }
}