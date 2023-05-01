package com.example.ekstrovertquiz.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ekstrovertquiz.R
import com.example.ekstrovertquiz.component.DetailComponent

@Composable
fun Detail(navController: NavController) {
    val component = DetailComponent()

    val isLoading = remember {
        mutableStateOf(true)
    }

    Scaffold(
        topBar = {
            component.TopBar(navController = navController )
        }
    ) {
        Surface(
            modifier = Modifier.padding(it),
            color = Color.White
        ) {
            LazyColumn(content = {
                item {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.detail_materi_image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth())
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(text = "Apakah Evolutionary Clusturing itu ?",
                            style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.primary,
                            fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Clustering: Menemukan grup objek sedemikiann " +
                                "rupa sehingga objek dalam grup akan serupan " +
                                "(atau terkait)n " +
                                "satu sama lain dan berbeda darin " +
                                "(atau tidak terkait dengan) objek dalam kelompokn " +
                                "lain.\n" + "Evolutionary Clustering: Penerapan algoritma " +
                                "evolusioner (juga dikenal sebagai genetik " +
                                "algoritma) untuk pengelompokan data (atau " +
                                "analisis cluster).",
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black,
                            fontSize = 12.sp)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(text = "Metode umum dalam Clustering: ",
                            style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.primary,
                            fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(text = "1. Metode partisi (K-means)\n" +
                                "2. Hierarchial Method\n" +
                                "3. Density-based method (DBSAN)",
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black,
                            fontSize = 12.sp)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = "K-Means Algorithm :",
                            style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.primary,
                            fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(text = "Centroid awal sering dipilih secara acak.\n" +
                                "• Cluster yang dihasilkan bervariasi dari satu " +
                                "proses ke proses lainnya.\n" +
                                "• Centroid adalah (biasanya) mean dari titik-titik " +
                                "dalam cluster.\n" +
                                "• 'Kedekatan' umumnya diukur dengan jarak " +
                                "Euclidean.\n" +
                                "• Seringkali kondisi berhenti diubah menjadi " +
                                "'Sampai relatif sedikit poin mengubah cluster'\n" +
                                "• Kompleksitas adalah O( n * K * I * d )\n" +
                                "• n = jumlah titik, K = jumlah cluster,\n" +
                                "I = jumlah iterasi, d = jumlah atribut",
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black,
                            fontSize = 12.sp)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(text = "Hierarchial Clustering:",
                            style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.primary,
                            fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(text = "Menghasilkan satu set cluster bersarang yang " +
                                "diatur sebagai pohon hierarkis\n• Dapat divisualisasikan sebagai dendogram\n• Sebuah pohon seperti diagram yang merekam " +
                                "urutan penggabungan atau pemisahan)",
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black,
                            fontSize = 12.sp)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = "Nonton videonya dulu yuk",
                            style = MaterialTheme.typography.h1,
                            color = MaterialTheme.colors.primary,
                            fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            component.VideoPlayer {
                                isLoading.value= it
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Yuk unduh materi pembelajarannya disini",
                            style = MaterialTheme.typography.h1,
                            color = Color.Black,
                            fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(6.dp))
                        component.MateriDownload()
                    }
                }
            })
        }
    }
}