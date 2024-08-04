package com.example.waterreminder

import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import com.example.waterreminder.utils.Constants
import kotlin.random.Random

class WaterNotificationServices(private val context: Context) {

    private val notificationManager = context.getSystemService(NotificationManager::class.java)

    fun showBasicNotification() {
        val notification = NotificationCompat.Builder(context, Constants.WATER_ID)
            .setContentTitle("Water Reminder")
            .setContentText("It's time to drink some water!")
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setSmallIcon(R.drawable.baseline_water_drop_24)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    fun showExpandedNotification() {
        val image = context.bitMapFromResource(R.drawable.water)
        val notification = NotificationCompat.Builder(context, Constants.WATER_ID)
            .setContentTitle("Water Reminder")
            .setContentText("It's time to drink some water!")
            .setPriority(NotificationManager.IMPORTANCE_MIN)
            .setSmallIcon(R.drawable.baseline_water_drop_24)
            .setLargeIcon(image)
            .setStyle(
                NotificationCompat
                    .BigPictureStyle()
                    .bigPicture(image)
                    .bigLargeIcon(null as Bitmap?)
            )
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    private fun Context.bitMapFromResource(@DrawableRes resId: Int) =
        BitmapFactory.decodeResource(resources, resId)

}