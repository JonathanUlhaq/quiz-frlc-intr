package com.example.ekstrovertquiz.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ekstrovertquiz.R
import com.example.ekstrovertquiz.component.DashboardComponent
import com.example.ekstrovertquiz.widgets.DashboardWidgets

@Composable
fun Dashboard(navController: NavController) {
    val component = DashboardComponent()
    val widget = DashboardWidgets()
    val showTask = remember {
        mutableStateOf(false)
    }
    val text = remember {
        mutableStateOf("")
    }
    val searchModal = remember {
        mutableStateOf(false)
    }

    if (searchModal.value) {
        component.SearchDropDown(boolean = searchModal, text = text)
    }

    Scaffold(
        topBar = {
            component.TopBar(onSearch = {
                searchModal.value = true
            }, onDrawer = {

            },
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
        ) {
            LazyColumn(content = {
                item {
                    Box {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(
                                    RoundedCornerShape(
                                        bottomStart = 10.dp,
                                        bottomEnd = 10.dp
                                    )
                                )
                                .height(166.dp)
                                .background(MaterialTheme.colors.primary)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.dashboard_line),
                                contentDescription = null
                            )
                        }

                        Column(modifier = Modifier.padding(bottom = 4.dp, start = 16.dp)) {
                            Text(
                                text = "Halo",
                                style = MaterialTheme.typography.h3,
                                fontSize = 16.sp,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Kurniawan",
                                style = MaterialTheme.typography.body2,
                                fontSize = 24.sp,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Box {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "All Upcoming Task",
                                        style = MaterialTheme.typography.h4,
                                        fontSize = 16.sp,
                                        color = Color.White
                                    )
                                    Spacer(modifier = Modifier.width(14.dp))

                                    Icon(
                                        painter = painterResource(id = R.drawable.dropdown_arrow),
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .clickable { showTask.value = true }
                                    )


                                }
                                component.TaskDropdown(show = showTask)
                            }

                            Spacer(modifier = Modifier.height(14.dp))
                            widget.TaskWidget {

                            }
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
                                        text = "Berita Terbaru",
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
                            widget.NewsWidget()
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

                items(5) {
                    component.CourseCard(title = "PEMBELAJARAN MESIN LANJUT - SUO", navController)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            })

        }
    }
}
