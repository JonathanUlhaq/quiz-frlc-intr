package com.example.ekstrovertquiz.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ekstrovertquiz.R
import com.example.ekstrovertquiz.navigation.MainRoutes

class MateriComponent {

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
                    Text(text = "Pembelajaran Mesin Lanjut",
                        style = MaterialTheme.typography.h1,
                        fontSize = 16.sp,
                        color = Color.Black)
                }
                Icon(painter = painterResource(id = R.drawable.action_icon),
                    contentDescription = null,
                    tint = Color(0xFF9F1521))
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun TaskCard(navController: NavController) {
        Surface(
            modifier = Modifier.width(185.dp) .height(80.dp),
            shape = RoundedCornerShape(10.dp),
            color = Color.White,
            elevation = 6.dp,
            onClick = {
                navController.navigate(MainRoutes.Quiz.route)
            }
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.quiz_background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(80.dp)
                )

                Column(
                    modifier = Modifier.padding(top = 11.dp,start = 11.dp, end = 11.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_telkom_universtiy),
                        contentDescription = null,
                        modifier = Modifier
                            .height(11.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Kuis W3",
                        style = MaterialTheme.typography.h1,
                        color = Color.Black,
                        fontSize = 12.sp,
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Genetic Algorithm",
                            style = MaterialTheme.typography.h3,
                            color = Color.Black,
                            fontSize = 11.sp
                        )
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            elevation = 4.dp,
                            color = Color.White,
                            contentColor = MaterialTheme.colors.primary,
                            modifier = Modifier.clickable { },
                            border = BorderStroke(0.2.dp,MaterialTheme.colors.primary)
                        ) {
                            Text(
                                text = "Submit",
                                style = MaterialTheme.typography.h5,
                                fontSize = 8.sp,
                                modifier = Modifier
                                    .padding(start = 6.dp, end = 6.dp, top = 1.dp, bottom = 1.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(7.dp))
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun MateriCard(navController: NavController,index:Int) {
        Surface(
            color = Color.Transparent,
            shape = RoundedCornerShape(10.dp),
            elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp,start = 16.dp),
            onClick = {
                navController.navigate(MainRoutes.DetailMateri.route)
            }
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(155.dp)
                        .background(
                            Brush.horizontalGradient(
                                listOf(
                                    MaterialTheme.colors.primary,
                                    Color(0xFFD9D9D9)
                                ),
                                startX = 250f
                            )
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gradient_materi_second),
                        contentDescription = null,
                        contentScale = ContentScale.Crop

                        )

                }

                Column(
                    modifier = Modifier.padding(top = 15.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier
                            .padding(start = 6.dp, end = 1.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.telkom_course_logo),
                            contentDescription = null,
                            modifier = Modifier
                                .height(63.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.telkom_text),
                            contentDescription = null,
                            modifier = Modifier
                                .height(48.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                        shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp),
                        color = Color.White,
                        elevation = 4.dp,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 11.dp,end = 2.dp,bottom = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = "Evolutionary Clustering",
                                        fontSize = 14.sp,
                                        style = MaterialTheme.typography.h6,
                                        color = Color.Black
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "Pertemuan 01",
                                        fontSize = 12.sp,
                                        style = MaterialTheme.typography.overline,
                                        color = Color.Black
                                    )
                                }
                            }
                            IconButton(onClick = { }) {
                                Icon(
                                    painter = if (index > 1) painterResource(id = R.drawable.check_circle) else painterResource(id = R.drawable.check_icon),
                                    contentDescription = null,
                                    tint = if (index > 1)  Color(0xFF6C6C6C) else  Color(0xFFB6252A)
                                )
                            }
                        }
                    }
                }


            }
        }
    }

    @Composable
    fun AnnounceCard(
        title: String,
        desc: String
    ) {
        Surface(
            modifier = Modifier.width(200.dp) .height(70.dp),
            shape = RoundedCornerShape(10.dp),
            color = Color.White,
            elevation = 6.dp
        ) {
            Box {

                Image(
                    painter = painterResource(id = R.drawable.abstract_background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(70.dp)
                )
                Column(modifier = Modifier.padding(start = 11.dp,end = 11.dp,top = 11.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_telkom_universtiy),
                        contentDescription = null,
                        modifier = Modifier
                            .height(11.dp)
                    )
                    Spacer(modifier = Modifier.height(9.dp))
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h1,
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = desc,
                        style = MaterialTheme.typography.h3,
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                }
            }
        }
    }

}