package com.karimali.movieapptask

import android.app.Application
import com.karimali.movieapptask.fcm.MyFirebaseMessagingService
import dagger.hilt.android.HiltAndroidApp

// This is Init Class.
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MyFirebaseMessagingService().listToTokenForDebug()
    }
}
