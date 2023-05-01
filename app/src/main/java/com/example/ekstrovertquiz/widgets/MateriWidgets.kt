package com.example.ekstrovertquiz.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ekstrovertquiz.component.MateriComponent

class MateriWidgets {
    private val component = MateriComponent()

    @Composable
    fun AnnouncementWidget() {
        LazyRow(content = {
            items(6) {
                component.AnnounceCard(title = "Link Drive Rekaman", desc ="https://drive.google.com/linkrekaman")
                Spacer(modifier = Modifier.width(14.dp))
            }
        })
    }

    @Composable
    fun TaskWidget(navController:NavController) {
        LazyRow(content = {
            items(6) {
                component.TaskCard(navController = navController)
                Spacer(modifier = Modifier.width(14.dp))
            }
        })
    }
}