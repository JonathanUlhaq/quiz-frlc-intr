package com.example.ekstrovertquiz.component

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ekstrovertquiz.R
import com.example.ekstrovertquiz.navigation.MainRoutes

class NilaiComponent {

    @Composable
    fun TopBar() {
        Surface(
            Modifier
                .fillMaxWidth(),
            color = Color.White,
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp,end = 16.dp, top = 10.dp, bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Nilai - nilai",
                        style = MaterialTheme.typography.h1,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }

        @Composable
        fun CourseCard(navController: NavController, title: String, kuis: String, nilai: String) {
            Surface(
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(12.dp),
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(MainRoutes.Task.route)
                    }
            ) {
                Box {
                    Box(
                        modifier = Modifier.height(100.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.End)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.arrow_nilai),
                                contentDescription = null
                            )
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.Start)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.circle_nilai),
                                contentDescription = null,
                                modifier = Modifier
                                    .offset(y = 16.dp, x = -(14).dp)
                            )
                        }
                    }

                    Column(
                        modifier = Modifier.padding(top = 6.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(start = 15.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.telkom_course_logo),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(height = 48.dp, width = 37.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = title,
                                style = MaterialTheme.typography.subtitle2,
                                color = Color.White,
                                modifier = Modifier.width(150.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                            shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp),
                            color = Color.White,
                            elevation = 4.dp,
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 15.dp, end = 15.dp, top = 8.dp, bottom = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = kuis,
                                        fontSize = 14.sp,
                                        style = MaterialTheme.typography.h1,
                                        color = Color.Black
                                    )
                                }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = nilai,
                                        fontSize = 14.sp,
                                        style = MaterialTheme.typography.body2,
                                        color = MaterialTheme.colors.primary
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))

                                    Icon(
                                        painter = painterResource(id = R.drawable.arrow_right),
                                        contentDescription = null,
                                        tint = MaterialTheme.colors.primary
                                    )
                                }


                            }
                        }
                    }


                }
            }
        }

}
