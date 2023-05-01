package com.example.ekstrovertquiz.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ekstrovertquiz.component.TaskComponent

@Composable
fun Task(navController: NavController) {
    val component = TaskComponent()
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            component.TopBar(navController = navController)
        }
    ) {
        Surface(
            Modifier
                .fillMaxSize()
                .padding(it),
            color = Color.White
        ) {

            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
            ) {
                Column(Modifier.padding(start = 16.dp, end = 16.dp,top = 8.dp)) {
                    Text(
                        text = "Status",
                        style = MaterialTheme.typography.h1,
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row {
                        component.TaskStatus(
                            color = Color(0xFF2C9009),
                            text = "Attempt"
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        component.TaskStatus(
                            color = MaterialTheme.colors.primary,
                            text = "Not Graded"
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Berkas",
                        style = MaterialTheme.typography.h1,
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    component.FolderCard()
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(
                        text = "Komentar",
                        style = MaterialTheme.typography.h1,
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Surface(
                        color = Color.Transparent,
                        border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .height(68.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.Start)
                                .padding(top = 8.dp, start = 12.dp)
                        ) {
                            Text(
                                text = "Tidak ada komentar untuk tugas ini",
                                style = MaterialTheme.typography.body1,
                                color = Color.Black,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(
                        text = "Last Modified",
                        style = MaterialTheme.typography.h1,
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Jum’at, 2 Februari 2023, 12:00",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.primary,
                        fontSize = 14.sp
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(
                        text = "Time Remaining",
                        style = MaterialTheme.typography.h1,
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Assigment was submited 4 jam early",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.primary,
                        fontSize = 14.sp
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(
                        text = "Batas Waktu",
                        style = MaterialTheme.typography.h1,
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Juma.at, 2 Februari 2023, 18:00",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.primary,
                        fontSize = 14.sp
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
                ) {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "EDIT SUBMISSION",
                            style = MaterialTheme.typography.h1,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .padding(top = 8.dp, bottom = 8.dp)
                        )
                    }
                }
            }
        }
    }
}