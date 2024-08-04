package com.example.waterreminder.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.waterreminder.R
import com.example.waterreminder.WaterNotificationServices
import com.example.waterreminder.ui.theme.WaterReminderTheme

@Composable
fun HomeScreen(
    waterService: WaterNotificationServices
) {
    var selected by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        RadioWithText(
            text = stringResource(R.string.basic_notification),
            isSelected = selected == 0,
            onClick = { selected = 0 })

        RadioWithText(
            text = stringResource(R.string.expanded_notification),
            isSelected = selected == 1,
            onClick = { selected = 1 })


        RadioWithText(
            text = stringResource(R.string.expanded_long_text_notification),
            isSelected = selected == 2,
            onClick = { selected = 2 })

        RadioWithText(
            text = stringResource(R.string.inbox_style_notification),
            isSelected = selected == 3,
            onClick = { selected = 3 })

        RadioWithText(
            text = stringResource(R.string.notification_group),
            isSelected = selected == 4,
            onClick = { selected = 4 })

        Spacer(modifier = Modifier.height(26.dp))
        Button(onClick = {
            when (selected) {
                0 -> waterService.showBasicNotification()
                1 -> waterService.showExpandedNotification()
                2 -> waterService.showExpandableLongText()
                3 -> waterService.showInboxStyleNotification()
                4 -> waterService.showNotificationGroup()
            }
        }) {
            Text(text = stringResource(id = R.string.show_notification))
        }

    }
}

@Composable
fun RadioWithText(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        RadioButton(
            selected = isSelected,
            onClick = onClick
        )
        Text(text = text)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomePreview() {
    WaterReminderTheme {
        val waterNotificationServices = WaterNotificationServices(LocalContext.current)
        HomeScreen(waterNotificationServices)
    }
}