package com.karimali.movieapptask.fcm

import android.annotation.TargetApi
import android.app.*
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import com.karimali.movieapptask.R
import com.karimali.movieapptask.ui.view.MoveActivity
import java.io.IOException

class OreoNotification(base: Context?) : ContextWrapper(base) {

    private var manager: NotificationManager? = null

    private val CHANNEL_ID = "com.karimali.movieapptask"
    private val CHANNEL_NAME = "movieApp"

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel()
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun createChannel() {
        val channel =
            NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
        channel.enableLights(true)
        channel.enableVibration(true)
        channel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        getManager()!!.createNotificationChannel(channel)
    }

    @TargetApi(Build.VERSION_CODES.O)
    fun createOreoNotification(
        remoteMessage: RemoteMessage,
        context: Context
    ): Notification? {

        var builder: NotificationCompat.Builder? = null

        try {
            builder = NotificationCompat.Builder(applicationContext,CHANNEL_NAME)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setContentTitle(remoteMessage.notification?.title)
                .setContentText(remoteMessage.notification?.body)
                .setSmallIcon(R.drawable.ic_notifications)
                .setAutoCancel(true)
                .setChannelId(CHANNEL_ID)
        }
        catch (e: IOException) {
            Log.i("NotificationEx",e.message.toString())
            e.printStackTrace()
        }

        val intent = MoveActivity.getInstance(
            context
        )

        val task =
            TaskStackBuilder.create(context)
        task.addNextIntent(intent)
        val pendingIntent = task.getPendingIntent(
            0,
            PendingIntent.FLAG_IMMUTABLE
        )
        builder?.setContentIntent(pendingIntent)
        return builder?.build()
    }

    fun getManager(): NotificationManager? {
        if (manager == null) {
            manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        }
        return manager
    }

}
