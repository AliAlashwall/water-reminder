package com.example.waterreminder.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.waterreminder.WaterNotificationServices
import com.example.waterreminder.ui.theme.WaterReminderTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    waterService: WaterNotificationServices
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { waterService.showBasicNotification() }) {
            Text(text = "Show Notification")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { waterService.showExpandedNotification() }) {
            Text(text = "Show Expanded Notification")
        }

    }
}

@Preview
@Composable
private fun HomePreview() {
    WaterReminderTheme {
        val waterNotificationServices = WaterNotificationServices(LocalContext.current)
        HomeScreen(waterNotificationServices)
    }
}