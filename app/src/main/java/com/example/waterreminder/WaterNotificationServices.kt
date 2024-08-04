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


    fun showExpandableLongText() {
        val notification = NotificationCompat.Builder(context, Constants.WATER_ID)
            .setContentTitle("Water Reminder")
            .setContentText("Time to drink some water!")
            .setSmallIcon(R.drawable.baseline_water_drop_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setStyle(
                NotificationCompat
                    .BigTextStyle()
                    .bigText("Very big text")
            )
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    fun showInboxStyleNotification() {
        val notification = NotificationCompat.Builder(context, Constants.WATER_ID)
            .setContentTitle("Water Reminder")
            .setContentText("Time to drink some water!")
            .setSmallIcon(R.drawable.baseline_water_drop_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setStyle(
                NotificationCompat
                    .InboxStyle()
                    .addLine("Line 1")
                    .addLine("Line 2")
                    .addLine("Line 3")
                    .addLine("Line 4")
                    .addLine("Line 5")
                    .addLine("Line 6")
                    .addLine("Line 7")
            )
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    fun showNotificationGroup() {

        val notification1 = NotificationCompat.Builder(context, Constants.WATER_ID)
            .setContentTitle("Water Reminder")
            .setContentText("Time to drink some water!")
            .setSmallIcon(R.drawable.baseline_water_drop_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setStyle(
                NotificationCompat
                    .InboxStyle()
                    .addLine("Line 1")
            )
            .setAutoCancel(true)
            .setGroup(Constants.WATER_GROUP_ID)
            .build()

        val notification2 = NotificationCompat.Builder(context, Constants.WATER_ID)
            .setContentTitle("Water Reminder")
            .setContentText("Time to drink some water!")
            .setSmallIcon(R.drawable.baseline_water_drop_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setStyle(
                NotificationCompat
                    .InboxStyle()
                    .addLine("Line 1")
                    .addLine("Line 2")
            )
            .setAutoCancel(true)
            .setGroup(Constants.WATER_GROUP_ID)
            .build()

        val summaryNotification = NotificationCompat.Builder(context, Constants.WATER_ID)
            .setContentTitle("Water Reminder")
            .setContentText("Time to drink some water!")
            .setSmallIcon(R.drawable.baseline_water_drop_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setStyle(
                NotificationCompat
                    .InboxStyle()
                    .setSummaryText("Water reminders missed")
                    .setBigContentTitle("Water Reminders")
            )
            .setAutoCancel(true)
            .setGroup(Constants.WATER_GROUP_ID)
            .setGroupSummary(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification1
        )
        notificationManager.notify(
            Random.nextInt(),
            notification2
        )
        notificationManager.notify(
            Random.nextInt(),
            summaryNotification
        )
    }


    private fun Context.bitMapFromResource(@DrawableRes resId: Int) =
        BitmapFactory.decodeResource(resources, resId)

}