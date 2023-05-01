package com.example.ekstrovertquiz.navigation

sealed class MainRoutes(val route:String) {
    object Materi:MainRoutes("materi")
    object Recomend:MainRoutes("recomend")
    object Task:MainRoutes("task")
    object Quiz:MainRoutes("quiz")
    object DetailMateri:MainRoutes("detailMateri")
}
