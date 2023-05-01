package com.example.ekstrovertquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ekstrovertquiz.component.BotNavBar
import com.example.ekstrovertquiz.component.BotNavBarContent
import com.example.ekstrovertquiz.component.DashboardComponent
import com.example.ekstrovertquiz.navigation.MainNavigation
import com.example.ekstrovertquiz.ui.theme.EkstrovertQuizTheme
import com.example.ekstrovertquiz.view.Dashboard
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EkstrovertQuizTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberAnimatedNavController()
                val contentId = remember {
                    mutableStateOf<Int?>(null)
                }
                val contentShow = remember {
                    mutableStateOf(false)
                }
                Scaffold(
                    bottomBar = {
                        if (!contentShow.value) {
                            BotNavBar(nav = navController)
                        } else {
                            BotNavBarContent(id = contentId.value , nav = navController )
                        }
                    }
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        color = MaterialTheme.colors.background
                    ) {
                        MainNavigation(navController = navController , contentId = contentId , contentShow = contentShow ) {


                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EkstrovertQuizTheme {
        Greeting("Android")
    }
}