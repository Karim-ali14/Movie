package com.karimali.movieapptask.fcm

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.media.RingtoneManager
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import com.karimali.movieapptask.R
import com.karimali.movieapptask.fcm.OreoNotification
import com.karimali.movieapptask.ui.view.MoveActivity
import kotlin.random.Random


class TypeOfNotifications {

    companion object {
        fun createOreoNotification(remoteMessage: RemoteMessage, context: Context) {

            val notification = OreoNotification(context)
            var notifictions: Notification? = null

            notifictions = notification.createOreoNotification(remoteMessage, context)
            notification.getManager()!!.notify((0..1000).random(), notifictions)
        }

        fun sendNotificationOrder(remoteMessage: RemoteMessage, context: Context) {

            val intent = MoveActivity.getInstance(
                context
            )

            val task =
                TaskStackBuilder.create(context)
            task.addNextIntent(intent)
            val pendingIntent = task.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            val Soung = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            var builder: NotificationCompat.Builder? = null

            builder = NotificationCompat.Builder(context)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_notifications)
//                .setLargeIcon(bitmap)
                .setContentTitle(remoteMessage.notification?.title)
                .setContentText(remoteMessage.notification?.body)
                .setSound(Soung)
//                .setNumber(++Common.CountMessageOrder)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)

            val manager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify((0..1000).random(), builder.build())
        }

    }
}