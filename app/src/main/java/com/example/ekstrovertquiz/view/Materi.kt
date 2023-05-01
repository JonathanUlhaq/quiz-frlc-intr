package com.example.ekstrovertquiz.view

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ekstrovertquiz.component.MateriComponent
import com.example.ekstrovertquiz.R
import com.example.ekstrovertquiz.widgets.MateriWidgets

@Composable
fun Materi(navController: NavController) {
    val componenet = MateriComponent()
    val widget = MateriWidgets()

    Scaffold(
        topBar = {
            componenet.TopBar(navController = navController)
        }
    ) {
        Surface(modifier = Modifier
            .padding(it)) {
            LazyColumn(content = {
                item {
                    Box {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                                .background(MaterialTheme.colors.primary)
                                .height(95.dp)
                        ) {
                            Image(painter = painterResource(id = R.drawable.materi_line), contentDescription = null )
                        }
                        Column(modifier = Modifier.padding(start = 16.dp, top = 12.dp,bottom = 4.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(modifier = Modifier
                                    .clip(RoundedCornerShape(topEnd = 2.dp, bottomEnd = 2.dp))
                                    .background(Color.White)
                                    .width(5.dp)
                                    .height(28.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "Announcement",
                                    style = MaterialTheme.typography.h5,
                                    fontSize = 16.sp,
                                    color = Color.White)
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            widget.AnnouncementWidget()
                            Spacer(modifier = Modifier.height(16.dp))
                            Row(
                                modifier = Modifier
                                    .padding(end = 16.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .clip(
                                                RoundedCornerShape(
                                                    topEnd = 30.dp,
                                                    bottomEnd = 30.dp
                                                )
                                            )
                                            .size(height = 28.dp, width = 5.dp)
                                            .background(MaterialTheme.colors.primary)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = "Tugas dan Kuis",
                                        fontSize = 16.sp,
                                        style = MaterialTheme.typography.h5,
                                        color = Color.Black
                                    )
                                }

                                IconButton(onClick = { }) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "View All",
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colors.primary,
                                            style = MaterialTheme.typography.body1
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Icon(
                                            painter = painterResource(id = R.drawable.dropdown_arrow),
                                            contentDescription = null,
                                            tint = MaterialTheme.colors.primary,
                                            modifier = Modifier.rotate(-90F)
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            widget.TaskWidget(navController = navController)
                            Spacer(modifier = Modifier.height(16.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(
                                            RoundedCornerShape(
                                                topEnd = 30.dp,
                                                bottomEnd = 30.dp
                                            )
                                        )
                                        .size(height = 28.dp, width = 5.dp)
                                        .background(MaterialTheme.colors.primary)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Course",
                                    fontSize = 16.sp,
                                    style = MaterialTheme.typography.h5,
                                    color = Color.Black
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))

                        }
                    }
                }
                items(6) { index ->
                    componenet.MateriCard(navController = navController, index = index )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            })
        }
    }

}