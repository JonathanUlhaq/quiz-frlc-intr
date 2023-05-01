package com.example.ekstrovertquiz.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.ekstrovertquiz.R
import com.example.ekstrovertquiz.navigation.MainRoutes

class DashboardComponent {

    @Composable
    fun TopBar(
        onSearch: () -> Unit,
        onDrawer: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Surface(
            color = MaterialTheme.colors.primary
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, end = 16.dp, top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = CenterVertically
            ) {
                IconButton(onClick = { onDrawer.invoke() }) {
                    Image(
                        painter = painterResource(id = R.drawable.dashboard_menu_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)

                    )
                }


                IconButton(onClick = { onSearch.invoke() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun MainCard(
        title: String,
        desc: String,
        onClick: () -> Unit
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier
                .width(300.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(11.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(End)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.telkom_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .offset(y = 32.dp)
                            .height(34.dp)
                    )
                }
                Column {
                    Row(
//                    verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.body1,
                                color = Color.Black,
                                fontSize = 14.sp,
                                modifier = Modifier.width(254.dp)
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = desc,
                                style = MaterialTheme.typography.h2,
                                color = Color.Black,
                                fontSize = 14.sp
                            )
                        }

                    }
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                    )


                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {

                            Text(
                                text = "Selasa, 27 Maret",
                                style = MaterialTheme.typography.h2,
                                color = Color.Black,
                                fontSize = 14.sp
                            )

                            Text(
                                text = "23:59",
                                style = MaterialTheme.typography.h1,
                                color = MaterialTheme.colors.primary,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .offset(y = (-6).dp)
                            )
                        }


                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colors.primary,
                            elevation = 8.dp,
                            onClick = {
                                onClick.invoke()
                            },
                            modifier = Modifier.offset(y = 8.dp)
                        ) {
                            Text(
                                text = "Add Submission",
                                style = MaterialTheme.typography.h1,
                                color = Color.White,
                                fontSize = 10.sp,
                                modifier = Modifier
                                    .padding(start = 6.dp, end = 6.dp, top = 5.dp, bottom = 5.dp)
                            )
                        }
                    }
                }
            }

        }
    }

    @Composable
    fun NewsCard(
        title: String,
        date: String
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier
                .width(200.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 8.dp

        ) {
            Box {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(End)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.news_pattern),
                        contentDescription = null,
                        modifier = Modifier
                            .height(70.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 9.dp, end = 9.dp,top = 9.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = R.drawable.logo_telkom_universtiy),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(11.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Admin CELOE",
                                style = MaterialTheme.typography.body1,
                                color = Color.Black,
                                fontSize = 10.sp,
                                modifier = Modifier.width(87.36.dp)
                            )
                        }

                    }
                    Spacer(modifier = Modifier.height(1.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = title,
                            fontSize = 10.sp,
                            style = MaterialTheme.typography.h1,
                            color = Color.Black
                        )
                        Surface(
                            shape = RoundedCornerShape(5.dp),
                            color = Color.White
                        ) {
                            Text(
                                text = date,
                                style = MaterialTheme.typography.h2,
                                color = MaterialTheme.colors.primary,
                                fontSize = 8.sp,
                                modifier = Modifier
                                    .padding(start = 5.dp, end = 5.dp, top = 1.dp, bottom = 1.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun CourseCard(
        title: String,
       navController: NavController
    ) {
        val showCourseDialog = remember {
            mutableStateOf(false)
        }

        Surface(
            color = Color.Transparent,
            shape = RoundedCornerShape(10.dp),
            elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp, start = 16.dp),
            onClick = {
                navController.navigate(MainRoutes.Materi.route)
            }
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
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
                    Box{
                        Image(
                            painter = painterResource(id = R.drawable.gradient_main_course_dua),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }

                }

                Column(
                    modifier = Modifier.padding(top = 15.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 6.dp, end = 1.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Row(
                            verticalAlignment = Alignment.Top
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.telkom_course_logo),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(63.dp)
                            )
                            Spacer(modifier = Modifier.width(9.dp))
                            Image(
                                painter = painterResource(id = R.drawable.telkom_course_text),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(48.dp)
                            )
                        }
                        IconButton(onClick = { showCourseDialog.value = true }) {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.triple_menu_icon),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .offset(y = -16.dp,x= 8.dp)
                                        .height(24.dp)
                                )
                                CourseDropDown(show = showCourseDialog)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Surface(
                        shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp),
                        color = Color.White,
                        elevation = 4.dp,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 8.dp, bottom = 15.dp, end = 15.dp),
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = CenterVertically
                            ) {
                                CircleProgress()
                                Spacer(modifier = Modifier.width(14.dp))
                                Column {
                                    Text(
                                        text = title,
                                        fontSize = 12.sp,
                                        style = MaterialTheme.typography.h1,
                                        color = Color.Black
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Row(
                                        verticalAlignment = CenterVertically
                                    ) {
                                        LinearProgressIndicator(
                                            progress = 0.75f,
                                            backgroundColor = Color(0xFFD9D9D9),
                                            strokeCap = StrokeCap.Round,
                                            modifier = Modifier
                                                .fillMaxWidth(0.85f)
                                                .height(7.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "65%",
                                            style = MaterialTheme.typography.h1,
                                            color = MaterialTheme.colors.primary,
                                            fontSize = 12.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }


            }
        }
    }

    @Composable
    fun SearchDropDown(
        boolean:MutableState<Boolean>,
        text:MutableState<String>
    ) {
        Dialog(onDismissRequest = { boolean.value = false }) {
            Column {
                TextField(value = text.value , onValueChange = {text.value = it},
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                        trailingIconColor = Color.Black
                    ),
                    trailingIcon = {
                        IconButton(onClick = { boolean.value = false }) {
                            Icon(painter = painterResource(id = R.drawable.close_icon),
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(14.dp))
                        }
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(270.dp)
                ) {

                }
            }
        }
    }

    @Composable
    fun TaskDropdown(show: MutableState<Boolean>) {
        val listOption = listOf(
            "All",
            "Overdue",
            "Next 3 Days",
            "Next 7 Days",
            "Next 14 Days",
            "Next 1 Month",
            "Next 2 Month",
            "Next 4 Month"
        )
        val currentIndex = remember {
            mutableStateOf(0)
        }
        MaterialTheme(shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(15.dp))) {
            DropdownMenu(expanded = show.value, onDismissRequest = { show.value = false }) {
                Column(
                    modifier = Modifier
                        .padding(top = 1.dp, bottom = 1.dp)

                ) {

                    listOption.forEachIndexed { index, item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = (index == currentIndex.value),
                                    onClick = {
                                        currentIndex.value = index
                                    }
                                )
                                .width(180.dp)
                                .padding(start = 8.dp, end = 14.dp),
                            verticalAlignment = CenterVertically,
                            horizontalArrangement = Arrangement.Absolute.SpaceBetween
                        ) {
                            Text(
                                text = item,
                                style = MaterialTheme.typography.body2,
                                fontSize = 14.sp,
                                color = if (index == currentIndex.value) MaterialTheme.colors.primary else Color.Black
                            )

                            RadioButton(
                                selected = (index == currentIndex.value),
                                onClick = { currentIndex.value = index },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = MaterialTheme.colors.primary,
                                    unselectedColor = Color.Black
                                ),
                                modifier = Modifier.size(8.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }

    @Composable
    fun CourseDropDown(show: MutableState<Boolean>) {
        val listTitle = listOf(
            "Download course",
            "Remove from view",
            "Star this course"
        )
        val listIcon = listOf(
            R.drawable.download_icon,
            R.drawable.remove_from_view_icon,
            R.drawable.star_icon
        )
        MaterialTheme(shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(8.dp))) {
            DropdownMenu(expanded = show.value, onDismissRequest = { show.value = false }) {
                Column(
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp)
                ) {
                    listTitle.forEachIndexed { index, item ->
                        Row(
                            verticalAlignment = CenterVertically,
                            modifier = Modifier
                                .width(186.dp)
                                .padding(start = 14.dp, end = 14.dp, top = 2.dp, bottom = 2.dp)
                                .clickable { show.value = false },


                            ) {
                            Icon(
                                painter = painterResource(id = listIcon[index]),
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(32.dp)
                                    .padding(end = 12.dp)
                            )

                            Text(
                                text = item,
                                fontSize = 12.sp,
                                style = MaterialTheme.typography.h5,
                                color = Color.Black,
                                textAlign = TextAlign.Start
                            )
                        }


                        if (index < 2) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Divider(color = Color.LightGray)
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                    }
                }


            }
        }

    }


    @Composable
    private fun CircleProgress() {
        val arcColor = MaterialTheme.colors.primary
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(20.dp * 2F)
        ) {
            Box(
                modifier = Modifier
                    .size(23.dp * 2F)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
            Box(
                modifier = Modifier
                    .size(17.dp * 2F)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            Canvas(
                modifier = Modifier
                    .size(20.dp * 2F)
            ) {
                drawArc(
                    color = arcColor,
                    -90F,
                    360 * 0.6F,
                    useCenter = false,
                    style = Stroke(6.dp.toPx(), cap = StrokeCap.Round)
                )
            }

            Text(
                text = "9/16",
                style = MaterialTheme.typography.h5,
                fontSize = 13.sp,
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }


}