package com.example.ekstrovertquiz.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ekstrovertquiz.R

class TaskComponent {

    @Composable
    fun TopBar(navController: NavController) {
        Surface(
            Modifier
                .fillMaxWidth(),
            color = Color.White,
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp,top = 10.dp, bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(painter = painterResource(id = R.drawable.dropdown_arrow),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .rotate(90f))
                    }
                    Text(text = "Tugas 01",
                        style = MaterialTheme.typography.h1,
                        fontSize = 16.sp,
                        color = Color.Black)
                }
            }
        }
    }

        @Composable
        fun TaskStatus(
            color: Color,
            text:String
        ) {
            Surface(
                shape = RoundedCornerShape(6.dp),
                color = color,
                elevation = 8.dp
            ) {
                Text(text = text,
                    style = MaterialTheme.typography.h1,
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 3.dp, bottom = 3.dp, end = 10.dp, start = 10.dp))
            }
        }

        @Composable
        fun FolderCard(
            modifier: Modifier = Modifier
        ) {
            Surface(
                shape = RoundedCornerShape(10.dp),
                elevation = 8.dp,
                color = MaterialTheme.colors.primary,
                contentColor = Color.White,
                modifier = modifier
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, end = 18.dp, start = 18.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.documnet_icon),
                            contentDescription = null,
                            tint = Color.White
                           )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(text = "Tugas 01_13011914116.pdf",
                            style = MaterialTheme.typography.h1,
                            fontSize = 14.sp,
                            color = Color.White)
                    }

                    Icon(painter = painterResource(id = R.drawable.download_icon),
                        contentDescription = null,
                        tint = Color.White)
                }
            }
        }
    }
