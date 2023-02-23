package com.karimali.movieapptask.fcm

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        Log.d("MyFirebaseMessaging", "From: " + remoteMessage.from);

        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            Log.d("MyFirebaseMessaging", "Message data payload: " + remoteMessage.getData());

        }

        // Check if message contains a notification payload.
        if (remoteMessage.notification != null) {
            Log.d("MyFirebaseMessaging", "Message notify payload: " + remoteMessage.notification?.title)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                TypeOfNotifications.createOreoNotification(
                    remoteMessage,
                    this)
            } else {
                TypeOfNotifications.sendNotificationOrder(
                    remoteMessage,
                    this)
            }
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    override fun onNewToken(token: String) {
        Log.e("newToken", token)
    }

    fun listToTokenForDebug(){
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
//            val msg = getString(R.string.msg_token_fmt, token)
            Log.d("FCMToken", token)
        })
    }

}