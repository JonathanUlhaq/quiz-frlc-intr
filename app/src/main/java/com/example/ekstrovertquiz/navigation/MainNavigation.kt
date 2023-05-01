package com.example.ekstrovertquiz.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import com.example.ekstrovertquiz.view.*
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavigation(navController: NavHostController,
                   contentId: MutableState<Int?>,
                   contentShow: MutableState<Boolean>,
                   clickDrawer:() -> Unit) {

    AnimatedNavHost(navController = navController, startDestination = BotNavRoute.Dashboard.route) {
        composable(BotNavRoute.Dashboard.route) {
            contentId.value = null
            contentShow.value = false
            Dashboard(navController)

        }
        composable(BotNavRoute.Calendar.route) {

        }
        composable(BotNavRoute.Notification.route) {

        }
        composable(BotNavRoute.Value.route) {
            contentId.value = null
            contentShow.value = false
            Nilai(navController = navController)

        }

        composable(MainRoutes.Materi.route) {
            contentShow.value = true
            contentId.value = 0
            Materi(navController)

        }
        composable(MainRoutes.Recomend.route) {
            contentShow.value = true
            contentId.value = 3

        }
        composable(MainRoutes.Task.route) {
            contentShow.value = true
            contentId.value = 3
            Task(navController = navController)

        }
        composable(MainRoutes.Quiz.route) {
            contentShow.value = true
            contentId.value = 0
            Quiz(navController = navController)

        }
        composable(MainRoutes.DetailMateri.route) {
            contentShow.value = true
            contentId.value = 0
            Detail(navController = navController)

        }

    }
}