package com.example.ekstrovertquiz.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ekstrovertquiz.R
import com.example.ekstrovertquiz.component.QuizComponent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Quiz(navController:NavController) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val listAnswerOne = listOf(
        "A. Operasi konvolusi dapat dilakukan dalam beberapa lapis layer.",
        "B. Dapat melakukan ekstraksi fitur dalam high-level seperti edges dari gambar",
        "C. Mempermudah proses capturing pada low-level features.",
        "D. Networks memiliki pemahaman yang baik terhadap suatu gambar di dalam dataset"
    )
    val listAnswerTwo = listOf(
        "A. Menambahkan skip layer dengan aturan secara random.",
        "B. Menghilangkan lapisan pada posisi yang telah dipilih",
        "C. Menambahkan pooling layer dengan aturan tertentu.",
        "D. Mengganti nilai parameter dari block dengan random pada posisi yang dipilih."
    )
    val listTitle = listOf(
        "ConvNets tidak perlu dibatasi terhadap satu layer konvolusi saja, agar…",
        "Berikut ini yang merupakan bukan ciri offspring generating adalah…"
    )


    val currentIndex = remember {
        mutableStateOf(0)
    }

    val component = QuizComponent()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutine = rememberCoroutineScope()

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = true,
            drawerShape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
            drawerContent = {

                Box(Modifier
                    .width(256.dp)
                    .fillMaxHeight()) {

                    Surface(
                        Modifier
                            .fillMaxHeight()
                            .width(220.dp),
                        color = Color.White,
                        elevation = 10.dp,
                        shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
                    ) {
                        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ) {
                            Column(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 20.dp)) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentWidth(CenterHorizontally)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.celoe_icon),
                                        contentDescription = null
                                    )
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(text = "Jumlah Soal",
                                    style = MaterialTheme.typography.h1,
                                    fontSize = 16.sp,
                                    color = Color.Black)
                                Spacer(modifier = Modifier.height(16.dp))
                                component.QuizNumber(currentIndex.value,indexClick = {
                                    currentIndex.value = it
                                    coroutine.launch {
                                        drawerState.close()
                                    }
                                })
                            }
                        }
                    }

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .wrapContentWidth(End)
                        .wrapContentHeight(CenterVertically)
                        .offset(y = 32.dp)) {
                        IconButton(onClick = {
                            coroutine.launch {
                                drawerState.close()
                            }
                        }) {
                            Image(painter = painterResource(id = R.drawable.button_arrow_in),
                                contentDescription = null,
                            modifier = Modifier
                                .height(60.dp))
                        }
                    }
                }

            },
            drawerBackgroundColor = Color.Transparent,
            drawerElevation = 0.dp) {
            ModalBottomSheetLayout(
                sheetContent = {
                    component.QuizBottomContent() {
                        coroutine.launch {
                            sheetState.hide()
                        }
                    }
                },
                sheetState = sheetState,
                sheetShape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp)
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ) {
                    Scaffold(
                        topBar = {
                            component.TopBar(navController = navController)
                        }
                    ) {
                        Box {

                            Surface(Modifier
                                .padding(it)) {

                                Column (
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(
                                            top = 18.dp,
                                            end = 16.dp,
                                            start = 16.dp,
                                            bottom = 16.dp
                                        )
                                ) {
                                    LazyColumn(content = {
                                        item {

                                            Box {

                                                Column {
                                                    Surface(
                                                        color = MaterialTheme.colors.primary,
                                                        shape = RoundedCornerShape(10.dp),
                                                        elevation = 8.dp
                                                    ) {
                                                        Row(
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                                .padding(
                                                                    start = 12.dp,
                                                                    end = 12.dp,
                                                                    top = 9.dp,
                                                                    bottom = 9.dp
                                                                ),
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            horizontalArrangement = Arrangement.SpaceBetween
                                                        ) {
                                                            component.MinuteCountdownWithTimeFormat()
                                                            component.QuestionSum(number = currentIndex.value)
                                                        }
                                                    }
                                                    Spacer(modifier = Modifier.height(16.dp))
                                                    component.Question(title = listTitle[currentIndex.value],
                                                        answer = if (currentIndex.value == 0) listAnswerOne else listAnswerTwo,
                                                        nextAppear = currentIndex.value < 1,
                                                        backAppear = currentIndex.value > 0,
                                                        next = { currentIndex.value = currentIndex.value + 1 }) {
                                                        currentIndex.value = currentIndex.value - 1
                                                    }
                                                }

                                            }
                                        }
                                    })

                                    Spacer(modifier = Modifier.weight(1f))
                                    Button(
                                        onClick = {
                                            coroutine.launch {
                                                sheetState.show()
                                            }
                                        },
                                        shape = RoundedCornerShape(10.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = MaterialTheme.colors.primary,
                                            contentColor = Color.White
                                        ),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Finish Attempt",
                                            style = MaterialTheme.typography.h1,
                                            fontSize = 16.sp,
                                            modifier = Modifier
                                                .padding(top = 2.dp, bottom = 2.dp)
                                        )
                                    }
                                }
                            }

                            if (!drawerState.isOpen) {
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .wrapContentWidth(End)
                                    .wrapContentHeight(CenterVertically)) {
                                    Image(painter = painterResource(id = R.drawable.button_arrow_out),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .height(60.dp)
                                            .clickable {
                                                coroutine.launch {
                                                    drawerState.open()
                                                }
                                            })
                                }
                            }

                        }
                    }
                }

            }
        }
    }


}