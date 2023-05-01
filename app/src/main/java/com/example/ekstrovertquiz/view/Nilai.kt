package com.example.ekstrovertquiz.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ekstrovertquiz.component.NilaiComponent

@Composable
fun Nilai(navController:NavController) {
    val component = NilaiComponent()

    val title = listOf(
        "Visualisasi Data - " +
                "PHG",
        "Pembelajaran Mesin " +
                "Lanjut - SUO",
        "Teori Bahasa Automata - " +
                "GIA ",
        "Manajemen Proyek - " +
                "SOL",
        "SISTEM PEMBERI " +
                "REKOMENDASI - ATW"
    )
    val kuis = listOf(
        "Tugas 01 - Pengenalan",
        "Kuis 2 - Pengenalan",
        "Tugas 1 - Pengenalan",
        "Kuis 2 - Pengenalan"
    )

    val nilai = listOf(
        "70 / 100",
        "80 / 100",
        "90 / 100",
        "70 / 100"
    )

   Scaffold(
       topBar = {
           component.TopBar()
       }
   ) {
       Surface(Modifier.padding(it)) {
           LazyColumn(
               modifier = Modifier
                   .padding(16.dp),
               content = {
               itemsIndexed(kuis) {
                   index, item ->
                   component.CourseCard(navController = navController,title[index],item,nilai[index])
                   Spacer(modifier = Modifier.height(14.dp))
               }

           })
       }
   }
}