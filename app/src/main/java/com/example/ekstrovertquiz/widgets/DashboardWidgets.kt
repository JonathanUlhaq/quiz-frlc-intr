package com.example.ekstrovertquiz.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ekstrovertquiz.component.DashboardComponent

class DashboardWidgets {

    private val component = DashboardComponent()

    @Composable
    fun TaskWidget(onClick:() -> Unit) {
        LazyRow(content = {
            items(5) {
                component.MainCard(title = "Pembelajaran  Mesin Lanjut - SUO", desc = "Tugas Grey Wolf Algorithm" ) {
                    onClick.invoke()
                }
                Spacer(modifier = Modifier.width(13.dp))
            }
        } )
    }

    @Composable
    fun NewsWidget() {
        LazyRow(content = {
            items(5) {
                component.NewsCard(title = "Maintenance LMS", date = "1 Maret, 10:41" )
                Spacer(modifier = Modifier.width(15.dp))
            }
        })
    }
}