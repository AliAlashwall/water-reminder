package com.example.waterreminder

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.waterreminder.utils.Constants

class NotificationApplication : Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        val notificationChannel = NotificationChannel(
            Constants.WATER_ID,
            "Water Reminder",
            NotificationManager.IMPORTANCE_HIGH
        )

        notificationChannel.description = getString(R.string.notification_description)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }
}