package com.example.waterreminder

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.waterreminder.ui.screens.HomeScreen
import com.example.waterreminder.ui.theme.WaterReminderTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WaterReminderTheme {
//                val postNotificationPermission = Manifest.permission.POST_NOTIFICATIONS

                val waterService = WaterNotificationServices(this)

                HomeScreen(waterService = waterService)
            }
        }
    }
}


